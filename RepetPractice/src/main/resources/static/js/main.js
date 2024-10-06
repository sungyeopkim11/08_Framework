const login = document.querySelector("#login");
const loginModal = document.querySelector("#loginModal");
const close = document.querySelector(".close");

login.addEventListener("click", e => {
    e.preventDefault();
    loginModal.style.display = "block";
});

close.addEventListener("click", () => {
    loginModal.style.display = "none";
});

window.addEventListener("click", e => {
    if(e.target === loginModal){
       loginModal.style.display = "none";
    }
});


