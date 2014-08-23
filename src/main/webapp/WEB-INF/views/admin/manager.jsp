<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String context = request.getContextPath();
	pageContext.setAttribute("context_", context);
%>
<!DOCTYPE html>

<!-- 

Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 2.3.1

Version: 1.3

Author: KeenThemes

Website: http://www.keenthemes.com/preview/?theme=metronic

Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469

-->

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

<meta charset="utf-8" />

<title>Metronic | Admin Dashboard Template</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="<%=context %>/views/admin/media/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link href="<%=context %>/views/admin/media/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />

<link href="<%=context %>/views/admin/media/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />

<link href="<%=context %>/views/admin/media/css/style-metro.css" rel="stylesheet" type="text/css" />

<link href="<%=context %>/views/admin/media/css/style.css" rel="stylesheet" type="text/css" />

<link href="<%=context %>/views/admin/media/css/style-responsive.css" rel="stylesheet"
	type="text/css" />

<link href="<%=context %>/views/admin/media/css/default.css" rel="stylesheet" type="text/css"
	id="style_color" />

<link href="<%=context %>/views/admin/media/css/uniform.default.css" rel="stylesheet"
	type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link href="<%=context %>/views/admin/media/css/jquery.gritter.css" rel="stylesheet"
	type="text/css" />

<link href="<%=context %>/views/admin/media/css/daterangepicker.css" rel="stylesheet"
	type="text/css" />

<link href="<%=context %>/views/admin/media/css/fullcalendar.css" rel="stylesheet" type="text/css" />

<link href="<%=context %>/views/admin/media/css/jqvmap.css" rel="stylesheet" type="text/css"
	<%=context %>/views/admin/media="screen" />

<link href="<%=context %>/views/admin/media/css/jquery.easy-pie-chart.css" rel="stylesheet"
	type="text/css" <%=context %>/views/admin/media="screen" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="<%=context %>/views/admin/media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<jsp:include page="common/header.jsp"></jsp:include>

	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<jsp:include page="common/leftSideBar.jsp"></jsp:include>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->
		<div class="page-content">
		</div>
		

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<jsp:include page="common/footer.jsp"></jsp:include>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="<%=context %>/views/admin/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="<%=context %>/views/admin/media/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="<%=context %>/views/admin/media/js/excanvas.min.js"></script>

	<script src="<%=context %>/views/admin/media/js/respond.min.js"></script>  

	<![endif]-->

	<script src="<%=context %>/views/admin/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.blockui.min.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.uniform.min.js" type="text/javascript"></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="<%=context %>/views/admin/media/js/jquery.vmap.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/date.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/daterangepicker.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/jquery.sparkline.min.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="<%=context %>/views/admin/media/js/app.js" type="text/javascript"></script>

	<script src="<%=context %>/views/admin/media/js/index.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL SCRIPTS -->

	<script>
		jQuery(document).ready(function() {

			App.init(); // initlayout and core plugins

			Index.init();

			Index.initJQVMAP(); // init index page's custom scripts

			Index.initCalendar(); // init index page's custom scripts

			Index.initCharts(); // init index page's custom scripts

			Index.initChat();

			Index.initMiniCharts();

			Index.initDashboardDaterange();

			Index.initIntro();

		});
	</script>

	<!-- END JAVASCRIPTS -->

	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-37564768-1' ]);
		_gaq.push([ '_setDomainName', 'keenthemes.com' ]);
		_gaq.push([ '_setAllowLinker', true ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://'
					: 'http://')
					+ 'stats.g.doubleclick.net/dc.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>

<!-- END BODY -->

</html>