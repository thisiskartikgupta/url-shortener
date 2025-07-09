document.addEventListener("DOMContentLoaded",function(){
    console.log("Successful");
    const input=document.querySelector(".input");
    const go=document.querySelector(".go");
    const hidden=document.querySelector(".hidden");
    const hidtxt=document.querySelector(".hid-txt");
    const all=document.querySelector(".all");
    const prefix="http://localhost:8080/original?url="

    all.addEventListener("click", function(){
        const list = document.querySelector(".list");
            fetch("http://localhost:8080/all")
                .then(res => res.json())
                .then(res => {
                    list.classList.add("showlist");
                    const entries = Object.entries(res);
                    const li = entries.map(([key, val]) =>
                        "<li><strong>"+key+"</strong>->  <a target=\"_blank\" href=\""+val+"\">"+val+"</li>"
                    ).join('');
                    list.innerHTML = `<ul>${li}</ul>`;
                })
    })
    go.addEventListener("click", function(){
        const big=input.value;
        fetch("http://localhost:8080/shorten?url=" + encodeURIComponent(big))
            .then(res => res.text())
            .then(res => {
                hidden.href=(prefix+res);
                hidden.textContent=prefix+res;
                hidden.classList.add("unhidden");
                hid-txt.classList.add("unhidden");
            });
    });
})