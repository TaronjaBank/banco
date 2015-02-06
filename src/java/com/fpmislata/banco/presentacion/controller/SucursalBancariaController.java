package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.dao.SucursalBancariaDAO;
import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.BussinessException;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/SucursalBancaria")
public class SucursalBancariaController {

    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;

    @Autowired
    JsonTransformer jsonTransformer;

    @RequestMapping(
            value = {"/{idSucursalBancaria}"},
            method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(idSucursalBancaria);
            sucursalBancaria.getEntidadBancaria().getIdEntidadBancaria();
            System.out.println(sucursalBancaria.getEntidadBancaria().getIdEntidadBancaria());
            String jsonSalida = jsonTransformer.toJson(sucursalBancaria);

            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public void insert(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) {
        try {
            SucursalBancaria sucursalBancariaEntrada = (SucursalBancaria) jsonTransformer.fromJson(jsonEntrada, SucursalBancaria.class);
            SucursalBancaria sucursalBancariaSalida = sucursalBancariaDAO.insert(sucursalBancariaEntrada);
            String jsonSalida = jsonTransformer.toJson(sucursalBancariaSalida);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            value = {"/{idSucursalBancaria}"},
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json")
    public void update(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria,
            @RequestBody String jsonEntrada) {
        try {
            SucursalBancaria sucursalBancaria = (SucursalBancaria) jsonTransformer.fromJson(jsonEntrada, SucursalBancaria.class);
            sucursalBancaria = sucursalBancariaDAO.update(sucursalBancaria);
            String jsonSalida = jsonTransformer.toJson(sucursalBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            value = {"/{idSucursalBancaria}"},
            method = RequestMethod.DELETE)
    public void delete(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            sucursalBancariaDAO.delete(idSucursalBancaria);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().println(jsonTransformer.toJson(sucursalBancariaDAO.findAll()));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            value = "/{idSucursalBancaria}/CuentaBancaria",
            method = RequestMethod.GET)
    public void finAllCuentasBySucursal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        {
            try {
                SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(idSucursalBancaria);
                Set<CuentaBancaria> cuentasBancarias = sucursalBancaria.getCuentasBancarias();
                String jsonSalida = jsonTransformer.toJson(cuentasBancarias);
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; char=UTF-8");
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        }
    }

    @RequestMapping(
            value = "/{idSucursalBancaria}/Empleado",
            method = RequestMethod.GET)
    public void finAllEmpleadosBySucursal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        {
            try {
                SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(idSucursalBancaria);
                Set<Empleado> empleados = sucursalBancaria.getEmpleados();
                String jsonSalida = jsonTransformer.toJson(empleados);
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; char=UTF-8");
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        }
    }
}
