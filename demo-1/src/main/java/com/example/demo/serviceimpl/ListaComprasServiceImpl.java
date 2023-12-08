package com.example.demo.serviceimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.ListaCompra;
import com.example.demo.entities.ListaCompraDetalle;
import com.example.demo.entities.ListaCompraProductosPK;
import com.example.demo.entities.Producto;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ListaCompraDetalleRepository;
import com.example.demo.repository.ListaCompraRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ListaCompras;
import com.example.demo.to.CambiarListaCompraTO;
import com.example.demo.to.ComprasTO;
import com.example.demo.to.ListaComprasTO;
import com.example.demo.to.ListaPruductoTO;
import com.example.demo.to.ListaCompraPKTO;

@Service
public class ListaComprasServiceImpl implements ListaCompras{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ListaCompraRepository listaCompraRepository;
	@Autowired
	private ListaCompraDetalleRepository listaCompraDetalleRepository;

	@Override
	public void agregarListaCompras(ComprasTO comprasTO) {
		
		List<Producto> productos = new ArrayList<>();
		List<ListaCompra> lstCompre =  new ArrayList<>();
		
		List<ListaComprasTO>  lstcomprasTO = comprasTO.getListasComprasTO();
		Map<ListaCompraPKTO, List<ListaPruductoTO>> listacompraPk =  new HashMap<>();
		
		for(ListaComprasTO lstcTO: lstcomprasTO) {
			Cliente cliente = this.clienteRepository.findById(lstcTO.getCliente()).get();
			ListaCompra listaCompra = new ListaCompra();
			listaCompra.setCliente(cliente);
			listaCompra.setNombre(lstcTO.getNombreLista());
			listaCompra.setActivo(Boolean.TRUE);
			Date fechaRegistro = Date.valueOf("2023-12-06");
			listaCompra.setFechaRegistro(fechaRegistro);
			lstCompre.add(listaCompra);					
			List<ListaPruductoTO> lst = lstcTO.getLista();
			for(ListaPruductoTO lstnlTO: lst) {
				Producto producto = new Producto();				
				producto.setIdProducto(lstnlTO.getIdProducto());
				producto.setActivo(Boolean.TRUE);
				productos.add(producto);												
				
				ListaCompraPKTO listaCompraPKTO = new ListaCompraPKTO();				
				listaCompraPKTO.setIdProducto(producto.getIdProducto());
				listaCompraPKTO.setNombreLista(listaCompra.getNombre());
				listaCompraPKTO.setCantidad(lstnlTO.getCantidad());
				listacompraPk.put(listaCompraPKTO, lst);
			}	
			
		}
		
		//save products
		this.productoRepository.saveAll(productos);
		//compra
		this.listaCompraRepository.saveAll(lstCompre);
		//save detalle 		
		this.listaCompraDetalleRepository.saveAll(this.procesarDetalle(listacompraPk));									
	}
	
	@Override
	public void modificarListaCompras(Long idClinte, CambiarListaCompraTO cambiarListaCompraTO) {
		List<ListaCompraDetalle> listasCompraDetalle = new ArrayList<>();
		List<Producto> productos = new ArrayList<>();
		Map<ListaCompraPKTO, List<ListaPruductoTO>> listacompraPk =  new HashMap<>();
		
		
		ListaCompra listaCompra = this.listaCompraRepository.findByClienteIdCliente(idClinte);
		listaCompra.setNombre(cambiarListaCompraTO.getNombreNuevo());
		Date fechaModificacion= Date.valueOf("2023-12-06");
		listaCompra.setFechaUltimaActualizacion(fechaModificacion);
		this.listaCompraRepository.save(listaCompra);
		
		for(ListaPruductoTO productoTO: cambiarListaCompraTO.getLista()) {
			Producto producto = new Producto();				
			producto.setIdProducto(productoTO.getIdProducto());
			producto.setActivo(Boolean.TRUE);
			productos.add(producto);	
			
			ListaCompraPKTO listaCompraPKTO = new ListaCompraPKTO();				
			listaCompraPKTO.setIdProducto(producto.getIdProducto());
			listaCompraPKTO.setNombreLista(listaCompra.getNombre());
			listaCompraPKTO.setCantidad(productoTO.getCantidad());
			listacompraPk.put(listaCompraPKTO, cambiarListaCompraTO.getLista());
		} 
		this.productoRepository.saveAll(productos);		
		this.listaCompraDetalleRepository.saveAll(this.procesarDetalle(listacompraPk));
		
	}
	
	@Override
	public void eliminarCompra(Long id) {
		this.listaCompraRepository.deleteById(id);
		
	} 
	
	private List<ListaCompraDetalle>  procesarDetalle (Map<ListaCompraPKTO, List<ListaPruductoTO>> listacompraPk) {
		List<ListaCompraDetalle> listasCompraDetalle = new ArrayList<>();
		
		listacompraPk.entrySet().forEach(l -> {
			ListaCompraPKTO listaCompraPKTO =l.getKey();
			ListaCompra listaCompra =this.listaCompraRepository.findByNombre(listaCompraPKTO.getNombreLista());
			ListaCompraDetalle listaCompraDetalle = new ListaCompraDetalle();
			ListaCompraProductosPK listaCompraProductosPK =new ListaCompraProductosPK();
			listaCompraProductosPK.setIdProducto(listaCompraPKTO.getIdProducto());
			listaCompraProductosPK.setIdLista(listaCompra.getIdLista());
			listaCompraDetalle.setCantidad(listaCompraPKTO.getCantidad());
			listaCompraDetalle.setListaCompraProductosPK(listaCompraProductosPK);
			listasCompraDetalle.add(listaCompraDetalle);
		} );
		return listasCompraDetalle;
	}

	@Override
	public List<ListaCompra> buscarListaCompra(Long idCliente) {		
		return this.listaCompraRepository.findByCliente(idCliente);
		
	}

	

	
}
