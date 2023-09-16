package com.utn.persistenciaJPA;

import com.utn.persistenciaJPA.entidades.*;
import com.utn.persistenciaJPA.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PersistenciaJpaApplication {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	RubroRepository rubroRepository;



	public static void main(String[] args) {

		SpringApplication.run(PersistenciaJpaApplication.class, args);
		System.out.println("Estoy funcionando");
	}


	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, DomicilioRepository domicilioRepository, DetallePedidoRepository detallePedidoRepository,
						   FacturaRepository facturaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository,
						   RubroRepository rubroRepository) {
		return args -> {
			System.out.println("PEDILOOOOOOOOOOOOOOOOOOOOOOO");


			//CREAMOS INSTANCIAS DE RUBROS

			Rubro rubro1 = Rubro.builder()
					.denominacion("Hamburguesas smash")
					.build();

			Rubro rubro2 = Rubro.builder()
					.denominacion("Papas fritas")
					.build();

			//CREAMOS INSTANCIAS DE PRODUCTOS

			Producto producto1 = Producto.builder()
					.precioCompra(800)
					.precioVenta(1000)
					.stockActual(15)
					.stockMinimo(4)
					.tiempoEstimadoCocina(10)
					.tipo(Producto.Tipo.insumo)
					.denominacion("Vegetales")
					.receta("Cortados en cuadritos")
					.unidadMedida("kg")
					.build();

			Producto producto2 = Producto.builder()
					.precioCompra(500)
					.precioVenta(900)
					.stockActual(5)
					.stockMinimo(2)
					.tiempoEstimadoCocina(20)
					.tipo(Producto.Tipo.manufacturado)
					.denominacion("Carne")
					.receta("coccion en plancha")
					.unidadMedida("kg")
					.build();

			Producto producto3 = Producto.builder()
					.precioCompra(700)
					.precioVenta(900)
					.stockActual(15)
					.stockMinimo(5)
					.tiempoEstimadoCocina(20)
					.tipo(Producto.Tipo.manufacturado)
					.denominacion("lechuga")
					.receta("lavar")
					.unidadMedida("gr")
					.build();


			//ASOCIAMOS PRODUCTO A RUBRO

			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			rubro2.agregarProducto(producto3);

			rubroRepository.save(rubro1);
			rubroRepository.save(rubro2);

			//CREAMOS INSTANCIAS DE CLIENTE

			Cliente cliente1 = Cliente.builder()
					.nombre("Juan")
					.apellido("PÃ©rez")
					.telefono(261415577)
					.email("juanP@gmail.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Francisco")
					.apellido("Manuel")
					.telefono(261416633)
					.email("francisco@gmail.com")
					.build();

			//CREAMOS INSTANCIAS DE DOMICILIO

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Av. San Martin")
					.numero(492)
					.localidad("Mendoza, Ciudad")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Las rabonas")
					.numero(157)
					.localidad("Mendoza, Las Heras")
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.calle("Chaco")
					.numero(2589)
					.localidad("Mendoza, Godoy Cruz")
					.build();

			//ASOCIAMOS DOMICILIO A CLIENTE

			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			cliente2.agregarDomicilio(domicilio3);

			//CREAR INSTANCIAS DE DETALLE PRODUCTO

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(120)
					.subtotal(938.15)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(300)
					.subtotal(500.15)
					.build();

			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(190)
					.subtotal(696.45)
					.build();

			DetallePedido detallePedido4 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(500)
					.build();


			//CREAMOS INSTANCIAS DE PEDIDO

			Pedido pedido1 = Pedido.builder()
					.estado(Pedido.Estado.Entregado)
					.tipoEnvio(Pedido.TipoEnvio.delivery)
					.total(9000)
					.fecha("22/06")
					.build();
			Pedido pedido2 = Pedido.builder()
					.estado(Pedido.Estado.Iniciado)
					.tipoEnvio(Pedido.TipoEnvio.retiro)
					.total(10000)
					.fecha("19/08")
					.build();

			Pedido pedido3 = Pedido.builder()
					.estado(Pedido.Estado.Iniciado)
					.tipoEnvio(Pedido.TipoEnvio.retiro)
					.total(121321)
					.fecha("9/12")
					.build();

			//CREAMOS INSTANCIAS FACTURA

			Factura factura1 = Factura.builder()
					.numero(20)
					.descuento(0.12)
					.formaPago(Factura.FormaPago.efectivo)
					.totalFactura(6000)
					.fecha("17/05")
					.build();

			Factura factura2 = Factura.builder()
					.numero(21)
					.descuento(0.19)
					.formaPago(Factura.FormaPago.mercadopago)
					.totalFactura(5000)
					.fecha("24/12")
					.build();

			Factura factura3 = Factura.builder()
					.numero(123)
					.descuento(0.19)
					.formaPago(Factura.FormaPago.mercadopago)
					.totalFactura(55600)
					.fecha("24/12")
					.build();


			//ASOCIAMOS PEDIDO A DETALLEPEDIDO

			pedido1.agregarDetalle(detallePedido1);
			pedido1.agregarDetalle(detallePedido2);
			pedido2.agregarDetalle(detallePedido3);
			pedido3.agregarDetalle(detallePedido4);

			//ASOCIAMOS CLIENTE CON PEDIDO

			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			cliente2.agregarPedido(pedido3);


			//ASOCIAMOS DETALLE CON PRODUCTO

			detallePedido1.setProductos(producto1);
			detallePedido2.setProductos(producto2);
			detallePedido3.setProductos(producto1);
			detallePedido4.setProductos(producto2);

			//ASOCIAMOS PEDIDO CON FACTURA

			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			pedido3.setFactura(factura3);


			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);


		};
	}
}


