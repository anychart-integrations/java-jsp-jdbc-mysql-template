<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <script src="https://cdn.anychart.com/releases/8.0.0/js/anychart-base.min.js"></script>
  <script src="https://cdn.anychart.com/releases/8.0.0/js/anychart-exports.min.js"></script>
  <script src="https://cdn.anychart.com/releases/8.0.0/js/anychart-vml.min.js"></script>
  <link rel="stylesheet" href="https://cdn.anychart.com/releases/8.0.0/css/anychart-ui.min.css" />
  <link rel="stylesheet" href="https://cdn.anychart.com/releases/8.0.0/fonts/css/anychart.min.css"/>
  <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>
<div id="container"></div>
<script>
  anychart.onDocumentReady(function() {
    var chart = anychart.pie(${chartData});
    chart.title("${chartTitle}");
    chart.container("container");
    chart.draw();
  });
</script>
</body>
</html>