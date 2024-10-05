// 모달과 a 태그 요소를 선택
const modal = document.getElementById("loginModal");
const link = document.getElementById("loginLink");
const span = document.getElementsByClassName("close")[0];

// a 태그 클릭 시 모달을 열기
link.onclick = function(event) {
    event.preventDefault(); // 링크의 기본 동작을 막기 위해 사용합니다.
    modal.style.display = "block"; // 모달을 화면에 보이게 설정합니다.
}

// 닫기 버튼 클릭 시 모달을 닫기
span.onclick = function() {
    modal.style.display = "none"; // 모달을 다시 감춥니다.
}

// 모달 외부를 클릭했을 때 모달을 닫기
window.onclick = function(event) {
    if (event.target === modal) { // 클릭한 대상이 모달 배경이라면
        modal.style.display = "none"; // 모달을 닫습니다.
    }
}