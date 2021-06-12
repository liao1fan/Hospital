<%--
  Created by IntelliJ IDEA.
  User: Mus1tang
  Date: 2021/6/10
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <style type="text/css">
        #box{
            border: chartreuse solid 1px;
            width: 600px;
            font-size: 16px;
        }
        #resultCon{
            margin-top: 5px;
            width: 600px;
            border: saddlebrown solid 1px;
        }
        span{
            background-color: #22c9e7;
        }
    </style>
    <div id="box">
        <form>
        <textarea id="textCon" rows="10" cols="70">
        </textarea>
            <p>
                Please enter content <input id="searchCon" type="text"/>
            </p>
        </form>
        <button id="search">search</button>
    </div>
    <div id="resultCon"></div>

    <script>
        document.getElementById("search").onclick=function(){

            //获取搜素模式
            var searchCon=document.getElementById("searchCon").value;
            var re=new RegExp(searchCon,"g");

            //获取搜索对象
            var textCon=document.getElementById("textCon").value;

            var start=0;
            var end=0;
            var newString="<p>";
            var arr;
            //生成新的字符串
            while((arr=re.exec(textCon))!=null){
                end=arr.index;

                newString+=textCon.substring(start,end);
                newString+="<span>"+arr[0]+"</span>";

                start=re.lastIndex;
            }
            newString+=textCon.substring(start,textCon.length)+"</p>";
            //输出显示
            document.getElementById("resultCon").innerHTML=newString;
        }
    </script>


</html>

