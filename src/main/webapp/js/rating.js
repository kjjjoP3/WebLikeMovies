const btn = document.querySelector(".click");
const post = document.querySelector(".post-1");
const widget = document.querySelector(".star-widget");
const editBtn = document.querySelector(".edit-1");
// btn.onclick = () => {
//     widget.style.display = "none";
//     post.style.display = "block";
//     editBtn.onclick = () => {
//         widget.style.display = "block";
//         post.style.display = "none";
//     }
//     return false;
// }

function check(u) {
    if (u == false) {
        widget.style.display = "none";
        post.style.display = "block";
    }
    else {
        widget.style.display = "block";
        post.style.display = "none";
    }
}