<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@import url('http://fonts.googleapis.com/css?family=Oswald:wght@700&display=swap');

*{margin:0; padding:0; box-sizing: border-box; font-family: 'Oswald', sans-serif;}
body{
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: url("bg_baduk.jpg") no-repeat center;
    background-size : cover;
    overflow:hidden;
}
.button{
    position:absolute;
    height: 60px;
    top:634px;
    right:545px;
}
.div{
    background-color:#DDC48D;
}
img{
    border: 0;
}
img:hover{
    transform:scale(1.3);
    z-index:2;
    cursor:url("pointer.png"), pointer;
}
.baduk{
    width:max-content;
    margin:20px;
    background:#DDC48D;
    line-height:0;
    letter-spacing: -130px;
    position: absolute;
    top:50%;
    left:50%;
    transform: translate(-50%, -50%);
    line-height: -120px;
}
.effect{
    position: absolute;
    height:190px;
    top:184px;
    left:435px;
}
.effect2{
    position: absolute;
    height:190px;
    top:184px;
    right:435px;
}
.bubbles{
    top:0;
    left:0;
    width:10px;
    height:10px;
    background : #4fc3dc;
    border-radius : 50%;
    box-shadow: 0 0 0 10px #4fc3dc44,
    0 0 50px #4fc3dc,
    0 0 100px #4fc3dc;
    animation: bubbles 15s linear infinite;
}
.bubbles:nth-of-type(2n){
    width:7px;
    height:7px;
    animation-duration: 7s;
    animation-delay: 1s;
}
.bubbles:nth-of-type(2n+1){
    width:6px;
    height:6px;
    animation-duration: 8s;
    animation-delay: 2s;
}
.bubbles:nth-of-type(5n){
    width:6px;
    height:6px;
    animation-duration: 9s;
    animation-delay: 3s;
}

.bubbles2{
    top:0;
    left:0;
    width:10px;
    height:10px;
    background : #5cfaff;
    border-radius : 50%;
    box-shadow: 0 0 0 10px #4fc3dc44,
    0 0 50px #5cfaff,
    0 0 100px #5cfaff;
    animation: bubbles2 15s linear infinite;
}
.bubbles2:nth-of-type(2n){
    width:7px;
    height:7px;
    animation-duration: 9s;
    animation-delay: 3s;
}
.bubbles2:nth-of-type(2n+1){
    width:6px;
    height:6px;
    animation-duration: 12s;
    animation-delay: 1s;
}
.bubbles2:nth-of-type(5n){
    width:6px;
    height:6px;
    animation-duration: 15s;
    animation-delay: 7s;
}


@keyframes bubbles{
    0%{
        opacity:0;
        transform: translateY(0);
    }
    20%{
        opacity: 1;
        transform: translate(-15px, 20vh);
    }
    40%{
        opacity: 1;
        transform: translate(15px, 40vh);
    }
    60%{
        opacity: 1;
        transform: translate(-15px, 60vh);
    }
    80%{
        opacity: 1;
        transform: translate(0, 80vh);
    }
    100%{
        opacity:1;
        transform: translateY(100vh);
}
}

@keyframes bubbles2{
    0%{
        opacity:0;
        transform: translateY(0);
    }
    20%{
        opacity: 1;
        transform: translate(-15px, 20vh);
    }
    40%{
        opacity: 1;
        transform: translate(15px, 40vh);
    }
    60%{
        opacity: 1;
        transform: translate(-15px, 60vh);
    }
    80%{
        opacity: 1;
        transform: translate(0, 80vh);
    }
    100%{
        opacity:1;
        transform: translateY(100vh);
}
}

.winner{
    position:absolute;
    height: 60px;
    top:34px;
    left:945px;
    width:130px;
    height:130px;
    transform-style:preserve-3d;
    transform: rotateX(-30deg);
    animation: animate 4s linear infinite;
}

@keyframes animate{
    0%
    {
        transform: rotateX(-30deg) rotateY(0deg);
    }
    100%
    {
        transform: rotateX(-30deg) rotateY(360deg);
    }
}
.winner div{
    position:absolute;
    top:0;
    left:0;
    width:100%;
    height:100%;
    transform-style:preserve-3d;
}

.winner div span{
    position: absolute;
    top:0;
    left:0;
    width:100%;
    height:100%;
    background:linear-gradient(#003cff, #19dafc);
    transform: rotateY(calc(90deg * var(--i))) translateZ(65px);
    display: flex;
    justify-content: center;
    align-items:center;
    transform-style: preserve-3d;
}
.winner div span h2{
    position:absolute;
    font-size:2.3em;
    color:#fff;
    transform:translateZ(10px);
}
.winner div span h2:nth-child(1){
    transform: translateZ(0) translateY(20px);
    color: white;
    filter: blur(1px);
}
.top{
    position:absolute;
    top:0;
    left:0;
    width:130px;
    height:130px;
    background: #003cff;
    transform: rotateX(90deg) translateZ(65px);
}
.top::before{
    content: '';
    position:absolute;
    top:0;
    left:0;
    width:130px;
    height:130px;
    background: #19dafc;
    transform: translateZ(-150px);
    filter: blur(20px);
    box-shadow: 0 0 95px rgba(0, 0, 255, 0.2),
    0 0 110px rgba(0, 0, 0, 255, 0.4),
    0 0 130px rgba(0, 0, 0, 255, 0.6),
    0 0 150px rgba(0, 0, 0, 255, 0.8),
    0 0 170px rgba(0, 0, 0, 255, 1);
}
.trans_button{
    height: 22px;
    width: 25px;
    border: none;
}
</style>
</head>
<body>


 

<button onmousedown="sound1.play()" type="button" class="trans_button"><img src="baduk_127.jpg"></button>
<c:forEach var="col" begin="1" end="19" step="1">
<button onmousedown="sound1.play()" type="button" data-row="${row} " data-col="${col }" class="trans_button"><img src="baduk_95.jpg"></button>
</c:forEach>
<button onmousedown="sound1.play()" type="button" class="trans_button"><img src="baduk_127_b.jpg"></button>

<button onmousedown="sound1.play()" type="button" class="trans_button"><img src="baduk_127.jpg"></button>
<c:forEach var="col" begin="1" end="19" step="1">
<button onmousedown="sound1.play()" type="button" data-row="${row} " data-col="${col }" class="trans_button"><img src="baduk_95.jpg"></button>
</c:forEach>
<button onmousedown="sound1.play()" type="button" class="trans_button"><img src="baduk_127_b.jpg"></button>




</body>
</html>