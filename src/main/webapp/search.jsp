<%--
  Created by IntelliJ IDEA.
  User: Mus1tang
  Date: 2021/6/11
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>清城</title>
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <style>
            .qcdromodel{width: 500px;margin: 0 auto}
            .qc-dromodel{
                display: none;
            }
            ul li{
                list-style: none;
            }
        </style>
    </head>
    <body>
        <section class="navigation">
            <div class="qcdromodel" style="margin-left: 5%;">
                <select class="" id="industryOf" name="industryOf" onclick="onezs();" style="height: 24px;width: 170px;height: 30px;-moz-appearance: none;pointer-events: none;">
                    <option value=""></option>
                </select>
                <input type="text" id="onezs" class="qc-zsearch" onclick="onezs();" style="height: 24px; width: 150px; position: absolute; left: 5%;"  placeholder="输入相应颜色">
                <ul class="qc-dromodel" id="modedata" style="padding-left: 0px;margin-top: 0px;width: 170px;display: none;margin-left: -7px;">
                    <input type="text" id="twoxj" class="qc-search" placeholder="输入相应颜色" style="height: 24px; width: 150px; position: absolute; left: 5%;top: 8px;">
                    <ul class="qc-dromodel_1" style="overflow: scroll;height: 300px;background-color: rgb(0, 188, 212);width: 100%;padding-left: 10px;display: block;">
                        <li><a href="javascript:;">红色</a></li>
                        <li><a href="javascript:;">大红色</a></li>
                        <li><a href="javascript:;">水红色</a></li>
                        <li><a href="javascript:;">粉红色</a></li>
                        <li><a href="javascript:;">黄hyhf色</a></li>
                        <li><a href="javascript:;">黄dahjdf色</a></li>
                        <li><a href="javascript:;">黄hydadhf色</a></li>
                        <li><a href="javascript:;">黄hyshf色</a></li>
                        <li><a href="javascript:;">黄h11yhf色</a></li>
                        <li><a href="javascript:;">黄hkolhf色</a></li>
                        <li><a href="javascript:;">黄hyhf5842色</a></li>
                        <li><a href="javascript:;">黄hyh*fsf色</a></li>
                        <li><a href="javascript:;">黄hy44hf色</a></li>
                        <li><a href="javascript:;">黄hy65hf色</a></li>
                        <li><a href="javascript:;">黄色</a></li>
                        <li><a href="javascript:;">蓝色</a></li>
                        <li><a href="javascript:;">橙色01</a></li>
                        <li><a href="javascript:;">橙色02</a></li>
                        <li><a href="javascript:;">橙色03</a></li>
                        <li><a href="javascript:;">橙色040</a></li>
                        <li><a href="javascript:;">橙色05</a></li>
                        <li><a href="javascript:;">黑色</a></li>
                        <li><a href="javascript:;">黑色B856YTS85R900</a></li>
                        <li><a href="javascript:;">白0色</a></li>
                        <li><a href="javascript:;">白1色</a></li>
                        <li><a href="javascript:;">白2色</a></li>
                        <li><a href="javascript:;">白3色</a></li>
                        <li><a href="javascript:;">白4色</a></li>
                        <li><a href="javascript:;">白5色</a></li>
                    </ul>
                </ul>
            </div>
        </section>
    </body>

    <script type="text/javascript">

        $(document).ready(function(){
            //点击空白收回下拉框
            $('.wew').click(function () {
                alert(11);
                $('.qc-dromodel').hide();
            });
            //搜索条件查询
            $(".qc-search").on('input propertychange', function () {
                var searchTerm = $(this).val();
                $(this).siblings('.qc-dromodel_1').show();
                $(this).addClass('cli');
                var searchSplit = searchTerm.replace(/ /g, "'):containsi('");
                $.extend($.expr[':'], {
                    'containsi': function(elem, i, match, array) {
                        return (elem.textContent || elem.innerText || '').toLowerCase()
                            .indexOf((match[3] || "").toLowerCase()) >= 0;
                    }
                });
                $(this).siblings('.qc-dromodel_1').find('li').not(":containsi('" + searchSplit + "')").each(function()   {
                    $(this).hide();
                });
                $(this).siblings('.qc-dromodel_1').find("li:containsi('" + searchSplit + "')").each(function() {
                    $(this).show();
                });
            });
            // input 输入框点击事件
            $('.qcdromodel').on('click', function(e){
                $(".qcdromodel").find("ul").hide();// 让ul隐藏（当你一个页面多个这样的输入框时你就会用到）
                $(this).find('ul').show();// 当前子节点显示
                e.stopPropagation();// 阻止事件冒泡
            });
            // 下拉框里面内容收起
            $('.qc-dromodel li a').on('click', function(e) {
                $("#onezs").css("display","block");
                $("#onezs").css("top","8px");
                $(this).parents('.qc-dromodel').hide().siblings('.qc-zsearch').removeClass('selected').removeClass('cli').val($(this).text());
                e.stopPropagation();// 阻止事件冒泡
            });
        });

        function onezs() {
            $("#onezs").css("display","none");
        }

    </script>

</html>


