</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <title>ECharts</title>
  <%@ include file="/WEB-INF/views/include/echarts.jsp" %>
</head>

<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="bar" style="height:400px"></div>
<div id="pie" style="height:400px"></div>
<script type="text/javascript">
  debugger;
  var a='${pageContext.request.contextPath}';
  // 路径配置
  require.config({
    paths: {
      echarts: '${pageContext.request.contextPath}/static/echarts-2.2.7/build/dist'
    }
  });
  // 使用
  require(
          [
            'echarts',
            'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
          ],
          function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('bar'));
            debugger;
            var option = {
              title : {
                text: '柱状图demo',
                subtext: '标准柱状图'
              },
              tooltip: {
                show: true
              },
              toolbox: {
                show : true,
                feature : {
                  saveAsImage : {show: true}
                }
              },
              legend: {
                data:['蒸发量','降雨量']
              },
              xAxis : [
                {
                  type : 'category',
                  data : ${month}
                }
              ],
              yAxis : [
                {
                  type : 'value'
                }
              ],
              series : [
                {
                  name:"蒸发量",
                  type:"bar",
                  data:${zfl},
                  markPoint : {
                    data : [
                      {type : 'max', name: '最大值'},
                      {type : 'min', name: '最小值'}
                    ]
                  },
                  markLine : {
                    data : [
                      {type : 'average', name: '平均值'}
                    ]
                  }
                },
                {
                  name:'降雨量',
                  type:'bar',
                  data:${jyl},
                  markPoint : {
                    data : [
                      {type : 'max', name: '年最高'},
                      {type : 'min', name: '年最低'}
                    ]
                  },
                  markLine : {
                    data : [
                      {type : 'average', name : '平均值'}
                    ]
                  }
                }
              ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
          }
  );
  require(
          [
            'echarts',
            'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
          ],
          function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('pie'));
            var option = {
              title : {
                text: '饼图demo',
                subtext: '标准饼图',
                x:'center'
              },
              tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
              },
              legend: {
                orient : 'vertical',
                x : 'left',
                data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
              },
              calculable : true,
              series : [
                {
                  name:'访问来源',
                  type:'pie',
                  radius : '55%',
                  center: ['50%', '60%'],
                  data:[
                        {value:335, name:'直接访问'},
                        {value:310, name:'邮件营销'},
                        {value:234, name:'联盟广告'},
                        {value:135, name:'视频广告'},
                        {value:1548, name:'搜索引擎'}]
          }
                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
          }
  );
</script>
</body>
</html>
