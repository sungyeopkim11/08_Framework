// 신고하기 버튼을 가져옴
const reportBtn = document.getElementById('reportBtn');

// 신고하기 버튼 클릭 시 팝업 창 열기
reportBtn.addEventListener('click', function() {
    // 새 창 열기 (팝업창 크기 지정)
    window.open(
        'board/reportPopup.html', // 팝업 창에 로드할 페이지
        '신고하기',          // 팝업 창 이름
        'width=500,height=600,scrollbars=yes' // 창 크기 및 옵션
    );
});
