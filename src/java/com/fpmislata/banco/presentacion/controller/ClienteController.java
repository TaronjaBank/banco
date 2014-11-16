package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    ClienteDAO clienteDAO;
    @Autowired
    JsonTransformer jsonTransformer;
}