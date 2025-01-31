package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.config.mysql.Sys_Order;
import com.example.service.test.Student;

import jakarta.annotation.Resource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties.Logging;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@RestController
@RequestMapping("/home")
public class ControllerTest {

	private static final Logger log = LoggerFactory.getLogger(ControllerTest.class);

	@Value("${server.port}")
	String port;

	@Resource
	private JdbcTemplate jdbcTemplate;

	// http://192.168.103.175:9001/home/hello
	@RequestMapping("/hello")
	public String home() {

		return "welcome, server port is ：" + port;
	}
	

	// http://192.168.103.175:9001/home/test/hellohere?username=jack&age=11
	@RequestMapping(value = "/test/{communityId}", method = RequestMethod.POST, params = { "username", "age!=10" })
	// @ResponseBody
	public String list(@PathVariable String communityId) {

		return communityId;
	}

	// http://192.168.103.175:9001/home/jsontest
	@RequestMapping(value = "/jsontest", produces = { "application/json; charset=UTF-8" })
	@ResponseBody
	// public String test(@RequestBody Student student) {
	public String test(@RequestBody Student student) {

		return student.getinfo(student.id);
	}

	// http://192.168.103.175:9001/home/jsontest2
	@RequestMapping(value = "/jsontest2", produces = { "application/json; charset=UTF-8" })
	@ResponseBody
	// public String test(@RequestBody Student student) {
	public String test2(@RequestBody Map<String, Object> map) {

		log.info("here is the log~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "{\"msg\":\"success\"}";
	}

	// http://192.168.103.175:9001/home/jdbc/mcc_znjx/check_order
	@RequestMapping(value = "/jdbc/mcc_znjx/check_order", produces = { "application/json; charset=UTF-8" })
	@ResponseBody
	public String list(@RequestBody Map<String, Object> requestid) {

		String id = (String) requestid.get("id");
		String sql = "SELECT client_document_no FROM sys_order where id=" + id;
		log.info("sql is : " + sql);
		List<Sys_Order> orderlist = jdbcTemplate.query(sql, new RowMapper<Sys_Order>() {
			Sys_Order order = null;

			@Override
			public Sys_Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				order = new Sys_Order();
				// order.setId(rs.getString("id"));
				order.setId(id);
				order.setClient_document_no(rs.getString("client_document_no"));
				log.info("client_document_no is " + order.toString());
				return order;
			}
		});
		return orderlist.get(0).toString();

	}

}
