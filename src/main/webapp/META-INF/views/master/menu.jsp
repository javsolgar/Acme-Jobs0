<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="https://www.informatica.us.es"/>
			<acme:menu-suboption code="master.menu.provider.Alfonso-favourite-link" action="https://www.twitch.tv"/>
			<acme:menu-suboption code="master.menu.anonymous.Rafa-favourite-link" action="https://www.youtube.com"/>
     	<acme:menu-suboption code="master.menu.anonymous.FcoJavier-favourite-link" action="https://ev.us.es/webapps/portal/execute/tabs/tabAction?tab_tab_group_id=_29_1"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.shout" action="/anonymous/shout/create"/>
			<acme:menu-suboption code="master.menu.anonymous.shout.list" action="/anonymous/shout/list"/>
      <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.gonzalez" action="/anonymous/gonzalez/create"/>
			<acme:menu-suboption code="master.menu.anonymous.gonzalez.list" action="/anonymous/gonzalez/list"/>
		<acme:menu-separator/>
		<acme:menu-suboption code="master.menu.anonymous.solis.create" action="/anonymous/solis/create"/>
		<acme:menu-suboption code="master.menu.anonymous.solis.list" action="/anonymous/solis/list"/>
      	  <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.gonzalezbulletin" action="/anonymous/gonzalezbulletin/create"/>
			<acme:menu-suboption code="master.menu.anonymous.gonzalezbulletin.list" action="/anonymous/gonzalezbulletin/list"/>
		<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.salasbulletin" action="/anonymous/salasbulletin/create"/>
			<acme:menu-suboption code="master.menu.anonymous.salasbulletin.list" action="/anonymous/salasbulletin/list"/>

      
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="https://www.informatica.us.es"/>
			<acme:menu-suboption code="master.menu.provider.Alfonso-favourite-link" action="https://www.twitch.tv"/>
			<acme:menu-suboption code="master.menu.provider.Rafa-favourite-link" action="https://www.youtube.com"/>
      <acme:menu-suboption code="master.menu.provider.FcoJavier-favourite-link" action="https://ev.us.es/webapps/portal/execute/tabs/tabAction?tab_tab_group_id=_29_1"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="https://www.informatica.us.es"/>
			<acme:menu-suboption code="master.menu.provider.Alfonso-favourite-link" action="https://www.twitch.tv"/>
			<acme:menu-suboption code="master.menu.consumer.Rafa-favourite-link" action="https://www.youtube.com"/>
      <acme:menu-suboption code="master.menu.consumer.FcoJavier-favourite-link" action="https://ev.us.es/webapps/portal/execute/tabs/tabAction?tab_tab_group_id=_29_1"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>


