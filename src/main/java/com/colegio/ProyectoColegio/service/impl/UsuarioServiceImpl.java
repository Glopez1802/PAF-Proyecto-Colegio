package com.colegio.ProyectoColegio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import lombok.extern.slf4j.Slf4j;

//import com.colegio.ProyectoColegio.components.Encoder;
import com.colegio.ProyectoColegio.entity.Usuario;
//import com.colegio.ProyectoColegio.exceptions.GeneralServiceException;
//import com.colegio.ProyectoColegio.exceptions.NoDataFoundException;
//import com.colegio.ProyectoColegio.exceptions.ValidateServiceException;
import com.colegio.ProyectoColegio.repository.UsuarioRepository;
import com.colegio.ProyectoColegio.service.UsuarioService;
//import com.colegio.ProyectoColegio.validators.UsuarioValidator;

//@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	//@Autowired
//	private Encoder encoder;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
		//} catch (ValidateServiceException | NoDataFoundException e) {
			//log.info(e.getMessage(), e);
			//throw e;
		//} catch (Exception e) {
			//log.error(e.getMessage(), e);
			//throw new GeneralServiceException(e.getMessage(), e);
		}
	

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		//} catch (ValidateServiceException | NoDataFoundException e) {
		//	log.info(e.getMessage(), e);
		//	throw e;
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
			//throw new GeneralServiceException(e.getMessage(), e);
		   return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByEmail(String email) {
		try {
			return repository.findByEmail(email);
		//} catch (ValidateServiceException | NoDataFoundException e) {
			//log.info(e.getMessage(), e);
			//throw e;
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
			//throw new GeneralServiceException(e.getMessage(), e);
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByEmailContaining(String email) {
		try {
			return repository.findByEmailContaining(email);
		} catch (Exception e) {
			return null;
		}
	}
	

	
	@Override
	@Transactional
	public Usuario create(Usuario obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
		//try {
			//Validación
			//UsuarioValidator.save(obj);
			//Usuario usuario=findByEmail(obj.getEmail());
			
			//if(usuario!=null) {
			//	throw new ValidateServiceException("Ya hay un registro con ese email");
			
			//Guardamos
			//String password=obj.getPassword();
			//obj.setPassword(encoder.encodePassword(password));
			//obj.setActivo(true);
		//	return repository.save(obj);
		//} catch (ValidateServiceException | NoDataFoundException e) {
		//	log.info(e.getMessage(), e);
		//	throw e;
	//}catch (Exception e) {
			//log.error(e.getMessage(), e);
			//System.out.println(e.getMessage());
			//throw new GeneralServiceException(e.getMessage(), e);
			//return null;

		

	@Override
	@Transactional
	public Usuario update(Usuario obj) {
		try {
			Usuario usuarioDb=repository.findById(obj.getId()).orElse(null);
			if(usuarioDb==null) {
				return null;
			}
			usuarioDb.setEmail(obj.getEmail());
			//usuarioDb.setPassword(obj.getPassword());
			return repository.save(usuarioDb);
		} catch (Exception e) {
			return null;

		}/*
		try {
			UsuarioValidator.save(obj);
			Usuario usuarioDb=findById(obj.getId());
			if(usuarioDb==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			Usuario usuario=findByEmail(obj.getEmail());
			if(usuario!=null && obj.getId()!=usuario.getId()) {
				throw new ValidateServiceException("Ya hay un registro con ese email");
			}
			//Actualizamos
			usuarioDb.setEmail(obj.getEmail());
			String password=obj.getPassword();
			usuarioDb.setPassword(encoder.encodePassword(password));
			return usuarioDb;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}*/
	}
	
	@Override
	@Transactional
	public int delete(int id) {
		try {
			Usuario usuarioDb=repository.findById(id).orElse(null);
			if(usuarioDb==null) {
				return 0;
			}else {
				repository.delete(usuarioDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	 @Autowired
	    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
	        this.repository = usuarioRepository;
	    }

	    @Override
	    public Usuario buscarPorEmail(String email) {
	        return repository.findByEmail(email);
	    }

	    @Override
	    public boolean validarContraseña(String email, String password) {
	        Usuario usuario = buscarPorEmail(email);
	        return usuario != null && usuario.getPassword().equals(password);
	    }
}
