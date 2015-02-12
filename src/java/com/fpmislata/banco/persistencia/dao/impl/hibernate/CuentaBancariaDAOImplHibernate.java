package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.dominio.TipoMovimiento;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.persistencia.dao.BussinessException;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate;
import static com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate.LOGGER;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import org.hibernate.Query;
import org.hibernate.Session;

public class CuentaBancariaDAOImplHibernate extends GenericDAOImplHibernate<CuentaBancaria> implements CuentaBancariaDAO {

    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Set<MovimientoBancario> movimientosBancarios = new HashSet();
            MovimientoBancario movimientoInicial = new MovimientoBancario();
            movimientoInicial.setConceptoMovimientoBancario("MovimientoInicial");
            movimientoInicial.setCuentaBancaria(cuentaBancaria);
            movimientoInicial.setTipoMovimiento(TipoMovimiento.HABER);
            movimientoInicial.setCantidadMovimientoBancario(0.0);
            movimientosBancarios.add(movimientoInicial);
            cuentaBancaria.setMovimientosBancarios(movimientosBancarios);
            session.save(cuentaBancaria);
            session.getTransaction().commit();
            return cuentaBancaria;
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public CuentaBancaria getFromNumeroCuenta(String numeroCuenta) throws BussinessException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT c FROM CuentaBancaria c WHERE numeroCuentaBancaria=:numeroCuenta");
        query.setParameter("numeroCuenta", numeroCuenta);
        CuentaBancaria cuentaBancaria = (CuentaBancaria) query.uniqueResult();
        if (cuentaBancaria != null) {
            session.getTransaction().commit();
            return cuentaBancaria;
        } else {

            throw new BussinessException("CuentaBancaria", "La cuenta Bancaria no puede ser nula");

        }

    }
}
