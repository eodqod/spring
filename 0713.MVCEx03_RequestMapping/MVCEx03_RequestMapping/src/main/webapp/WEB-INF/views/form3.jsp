<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<button id="postData1">데이터 전송1</button>
<button id="postData2">데이터 전송2</button>
<button id="postData3">데이터 전송3</button>
<script>
    const $postDataButton1 = document.querySelector("#postData1")
    const postData1 = event => {
        console.log("데이터 전송");

        fetch("receive3", {
            method: 'post',
            headers: {
                'content-type': 'application/json'
            },
            body : JSON.stringify({
                name : "jun",
                age : "13"
            })
        })
    }
    $postDataButton1.addEventListener("click", postData1);
    
    const $postDataButton2 = document.querySelector("#postData2")
    const postData2 = event => {
        console.log("데이터 전송");

        fetch("receive4", {
            method: 'post',
            headers: {
                'content-type': 'application/json'
            },
            body : JSON.stringify({
                name : "jun",
                age : "13"
            })
        })
    }
    $postDataButton2.addEventListener("click", postData2);
    
    const $postDataButton3 = document.querySelector("#postData3")
    const postData3 = event => {
        console.log("데이터 전송");

        fetch("receive5", {
            method: 'post',
            headers: {
                'content-type': 'application/json'
            },
            body : JSON.stringify({
                name : "jun",
                age : "13"
            })
        })
    }
    $postDataButton3.addEventListener("click", postData3);
    
</script>
</body>
</html>