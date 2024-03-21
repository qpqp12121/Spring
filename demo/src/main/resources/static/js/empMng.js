/* 모듈화하기 
=> 객체 통해서만 접근 가능 (empService.--)
(empMng.html에서 onclick이벤트 등 수정함 참고)*/

//function들 즉시실행함수로 감싸고 infoReq, saveReq, listReq 함수들만 return 시킴)
// => var empService = {infoReq, saveReq, listReq}

var empService = (function() {

	/* ajax 요청 & 응답 세트로 */
	//=================================================
	
	//사원리스트 요청
	// (등록삭제 등 처리 후 append로 후처리 못 하겠으면? 리스트만 다시 불러오게 처리하기 위해 따로 함수로 만듦
	
	function listReq(p) {
	//async function listReq(p) {
		const param = "?page=" + p //get방식 (/ajax/empList?page=값)
				
		/* fetch("/ajax/empList" + param)
		.then(res => res.json())
		.then(res => listRes(res)); */
		
		/* 비동기식 axios 사용 (json() parsing은 안 적어도 알아서 함)*/
		axios.get("/ajax/empList" + param)
		.then(res => listRes(res.data)); //__.data적어야 됨!
		
		//동기식
		/*const res = await axios.get("/ajax/empList" + param);
		listRes(res.data)*/
	}
	
	
	 
	//사원리스트 응답
	function listRes(res) {
		
		let i=0; // NO.
		//목록출력
		emplist.innerHTML = '';
		
		for(empObj of res.data) { //controller에서 목록 넘기는 거 "data"로 넘김(데이터건수는 "count"로)
			emplist.innerHTML += makeTr(++i, empObj);
		}
		
		//페이징처리
		nav.innerHTML = makePage(res.paging) //컨트롤러에서 map에 담아준 값 "paging"
		
	}
	
	//사원리스트 응답 for문 안에 있던 거 따로 함수로
	function makeTr(i, obj) {
		//button 조건
		let bonusBtn = '<button>신청</button>';
		if(empObj.salary > 10000) {
			bonusBtn = '<button>미신청</button>'; /* 밖에서 if문으로 만들고 아래 삽입 */
		}
		
		//table body 삽입
		let newTag = `
			<tr>
				<td>${i}</td>
				<td onclick="infoReq(${empObj.employeeId})">${empObj.employeeId}</td>
				<td>${empObj.firstName} ${empObj.lastName}</td>
				<td>${dateFormat(empObj.hireDate)}</td>
				<td>${empObj.salary}</td>
				<td>${bonusBtn}</td>
				<td><button type="button" onclick="move(${empObj.employeeId})">조회</button></td> <!-- ajax에선 th: 못 씀 -->
			</tr>`
		return newTag;
	}
	//============
	//페이징
	function makePage(paging) {
		let tag = `<nav aria-label="...">
			  <ul id="ust">`
		//이전버튼
		if(paging.startPage > 1) {
			tag += `<li> 
		        <a class="page-link" href="javascript:gopage(${paging.startPage-1})">Previous</a></li>`
		}
		//페이지번호	  
		for(num=paging.startPage; num <= paging.endPage; num++) { //num: 페이지번호
			tag += `<li>
		        <a class="page-link" href="javascript:gopage(${num})">${num}</a></li>`
		}
		//다음버튼
		if(paging.endPage < paging.lastPage) { // <= 에서 고쳐서 Next안보임
			tag += `<li>
		        <a class="page-link" href="javascript:gopage(${paging.endPage+1})">Next</a></li>`
		}
		tag += `</ul>
			</nav>`
		return tag;
	}
	
	
	
	//============
	
	//날짜format
	function dateFormat(dt) {
			console.log(dt);
			let date = new Date(dt);
			
			let year = date.getFullYear();
			let month = ( 1 + date.getMonth() );
			let day = date.getDate();
			
			month = month >= 10 ? month : '0' + month; //10미만일 시 앞에 0을 붙혀서 저장
			day = day >= 10 ? day : '0' + day;
			
			return `${year}년 ${month}월 ${day}일`;
	}
	//======================================================
	//상세조회 요청
	function infoReq(employeeId) {
		//fetch("/ajax/emp/" + employeeId)
		fetch(`/ajax/emp/${employeeId}`)
		.then(res => res.json())
		.then(res => infoRes(res))
	}
	
	//상세조회 응답
	function infoRes(res) {
		//input태그에 해당 사원 정보 표시
		frm.lastName.value = res.lastName;
		frm.email.value = res.email;
		frm.hireDate.value = res.hireDate;
		frm.jobId.value = res.jobId;
	}
	
	
	//======================================================
	//등록 요청 (3가지 방식)
	//1.첫번째방법: queryString 직접 만들기
	/* function saveReq() {
		const lastName = frm.lastName.value;
		const email = frm.email.value;
		const hireDate = frm.hireDate.value;
		const jobId = frm.jobId.value;
		
		let param = `lastName=${lastName}&email=${email}&hireDate=${hireDate}&jobId=${jobId}`
		fetch("/ajax/emp", { //데이터 있으면 fetch("url", option) -- 데이터는 body에 실어서
			method : "post",
			headers: {
			      "Content-Type": "application/x-www-form-urlencoded",
			    },
			body : param
			
		})
		.then(res => res.json())
		.then(res => saveRes(res))
	} */
	
	//2.두번째방법: formData 첨부파일도 가능
	/* function saveReq() {
		let param = new FormData(document.frm);
		fetch("/ajax/emp", {
			method : "post",
			body : param	
		})
		.then(res => res.json())
		.then(res => saveRes(res))
	} */
	
	//3.세번째방법: json
	function saveReq() {
		const lastName = frm.lastName.value;
		const email = frm.email.value;
		const hireDate = frm.hireDate.value;
		const jobId = frm.jobId.value;
		
		let param = {lastName, email, jobId, hireDate }
		
		/* fetch("/ajax/emp", { 
			method : "post",
			headers: {
				"Content-Type": "application/json",
			    },
			body : JSON.stringify(param)
			
		})
		.then(res => res.json())
		.then(res => saveRes(res)) */
		
		
		axios.post("/ajax/emp", param)
		.then(res => saveRes(res.data))
	}
			
	//등록 응답
	function saveRes(res) {
		//console.log(res)
		listReq(1); //안에 (p) 첫번째 페이지로드하라고 인수 넣어줘야 됨
	}


return { infoReq, saveReq, listReq }
})();
