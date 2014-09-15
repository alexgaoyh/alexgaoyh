<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="page-sidebar nav-collapse collapse">

	<!-- BEGIN SIDEBAR MENU -->

	<ul class="page-sidebar-menu">

		<li>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

			<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

		</li>


		<li class="start active ">
			<a href="index.html"> <i class="icon-home"></i> <span class="title">${sysmanUser.userName}</span> <span class="selected"></span> </a>
		</li>

		<c:forEach var="leftMenu" items="${sysmanResourceList}">
			<li class="">
				<a href="javascript:;"> 
					<i class="icon-cogs"></i> <span class="title"><c:out value="${leftMenu.name }"></c:out></span> <span class="arrow "></span>
				</a>
				<c:if test="${leftMenu.subResource != null||leftMenu.subResource.length > 0}">
					<ul class="sub-menu">
						<c:forEach var="leftSubMenu" items="${leftMenu.subResource}">
							<li><a href="${leftSubMenu.href }"> ${leftSubMenu.name } </a></li>
						</c:forEach>
	
					</ul>
				</c:if>
			</li>
		</c:forEach>


	</ul>

	<!-- END SIDEBAR MENU -->

</div>