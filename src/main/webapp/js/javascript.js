const toTop = document.querySelector(".to-top");

window.addEventListener("scroll", ()=>{
    if(window.pageYOffset > 500){
        toTop.classList.add("active");
    }else{
        toTop.classList.remove("active");
    }
})


function find() {
    var show = document.getElementById("find");
    //alert(show.style.display);
    if (show.style.display == "none") {
        show.style.display = "block";
    }
    else {
        show.style.display = "none";
    }
}


$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip();
});

var maxWidth = 0;
function Page(max){
     if(parseInt(max)>=8){
         var last = document.getElementById("page7");
         last.innerText = max;
         var prevLast = document.getElementById("page6");
         prevLast.innerText = "...";
         var parent = document.getElementById("page6");
        parent.parentNode.classList.add('disabled');
         for(var i = 1; i<=5; i++){
            var param = document.getElementById("page"+i).innerText = i;
         }
     }
     Handle(1);
     maxWidth = max;
}

var flag = 0;
function Handle(numb){
    if(flag == 0){
        var parent = document.getElementById("page"+numb);
        parent.parentNode.classList.add('active');
        flag = numb;
    }
    else if(numb == flag){
        var parent = document.getElementById("page"+numb);
        parent.parentNode.classList.add('active');
    }
    else{
        var parent = document.getElementById("page"+numb);
        parent.parentNode.classList.add('active');
        var del = document.getElementById("page"+flag);
        del.parentNode.classList.remove('active');
        flag = numb;
    }

    
    
}

function Login(check){
    var noLo = document.getElementById("NotLogin");
    var Lo = document.getElementById("Login");  
    if(check == true){
        Lo.style.display = "block";
        noLo.style.display = "none";
     }
     else{
        Lo.style.display = "none";
        noLo.style.display = "block";
     }
}



