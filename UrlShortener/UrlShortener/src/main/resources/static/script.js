document.addEventListener("DOMContentLoaded",function(){
    console.log("Successful");
    const input=document.querySelector(".input");
    const button=document.querySelector(".go");
    const hidden=document.querySelector(".hidden");

    button.addEventListener("click", function(){
        const big=input.value;
        fetch("http://localhost:8080/bigurl?bigurl=" + encodeURIComponent(big))
            .then(res => res.text())
            .then(res => {
                hidden.textContent = "Shortened URL is: " + res;
                hidden.classList.add("unhidden");
            });


    });
})