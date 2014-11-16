package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoDAO empleadoDAO;
    @Autowired
    JsonTransformer jsonTransformer;
}