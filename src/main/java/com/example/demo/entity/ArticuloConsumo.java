package com.example.demo.entity;
	
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
	public class ArticuloConsumo extends EntidadGenerica implements Serializable{
		
	
		private static final long serialVersionUID = 1L;
		
		@Column(name = "Id")
		private long id;
		
		@Column(name = "Denominacion")
		private String denominacion;
		
		@Column(name = "PrecioCompra")
		private double precioCompra;
		
		@Column(name = "PrecioVeta")
		private double precioVenta;
		
		@Column(name = "StockActual")
		private double stockActual;
		
		@Column(name = "stockMinimo")
		private double stockMinimo;
		
		@Column(name = "UnidadMedida")
		private String unidadMedida;
		
		@Column(name = "EsInsumo")
		private boolean esInsumo;
		
		@Column(name = "imagen")
		private String imagen;
		
		/*@OneToMany(mappedBy="articuloConsumo" ,cascade = CascadeType.ALL, orphanRemoval=true)
		@Column(name = "detalle_factura")
		private List<DetalleFactura> detallesFactura = new ArrayList<DetalleFactura>();
		
		@OneToMany(mappedBy="articuloConsumo" ,cascade = CascadeType.ALL, orphanRemoval=true)
		@Column(name = "detalle_pedido")
		private List<DetallePedido> detallesPedido = new ArrayList<DetallePedido>();
		*/
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id_rubroArticulo")
		private RubroArticulo rubroArticulo;
		
		@OneToMany(mappedBy="articuloConsumo" ,cascade = CascadeType.ALL, orphanRemoval=true)
		@Column(name = "artManufDetalle")
		private List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalle= new ArrayList<ArticuloManufacturadoDetalle>();

		public ArticuloConsumo() {
			super();
		}
		

		
		public ArticuloConsumo(long id,String denominacion, double precioCompra, double precioVenta, double stockActual,
				double stockMinimo, String unidadMedida, boolean esInsumo, List<DetalleFactura> detallesFactura,
				List<DetallePedido> detallesPedido, RubroArticulo rubroArticulo, String imagen) {
			super();
			this.id = id;
			this.denominacion = denominacion;
			this.precioCompra = precioCompra;
			this.precioVenta = precioVenta;
			this.stockActual = stockActual;
			this.stockMinimo = stockMinimo;
			this.unidadMedida = unidadMedida;
			this.esInsumo = esInsumo;
			/*this.detallesFactura = detallesFactura;
			this.detallesPedido = detallesPedido;*/
			this.rubroArticulo = rubroArticulo;
			this.imagen = imagen;
		}



		public ArticuloConsumo(long id,String denominacion, double precioCompra, double precioVenta, double stockActual,
				double stockMinimo, String unidadMedida, boolean esInsumo, List<DetalleFactura> detallesFactura,
				List<DetallePedido> detallesPedido, String imagen) {
			super();
			this.id = id;
			this.denominacion = denominacion;
			this.precioCompra = precioCompra;
			this.precioVenta = precioVenta;
			this.stockActual = stockActual;
			this.stockMinimo = stockMinimo;
			this.unidadMedida = unidadMedida;
			this.esInsumo = esInsumo;
			/*this.detallesFactura = detallesFactura;
			this.detallesPedido = detallesPedido;*/
			this.imagen = imagen;
		}



		public ArticuloConsumo(long id,String denominacion, double precioCompra, double precioVenta, double stockActual,
				double stockMinimo, String unidadMedida, boolean esInsumo, String imagen) {
			super();
			this.id = id;
			this.denominacion = denominacion;
			this.precioCompra = precioCompra;
			this.precioVenta = precioVenta;
			this.stockActual = stockActual;
			this.stockMinimo = stockMinimo;
			this.unidadMedida = unidadMedida;
			this.esInsumo = esInsumo;
			this.imagen = imagen;
			
		}

		
		//GETTERS Y SETTERS ------------------------------------------------------------------------
		
		
		
		

		public RubroArticulo getRubroArticulo() {
			return rubroArticulo;
		}

		public long getId() {
			return id;
		}

		public void setRubroArticulo(RubroArticulo rubroArticulo) {
			this.rubroArticulo = rubroArticulo;
		}

/*
		public List<DetalleFactura> getDetallesFactura() {
			return detallesFactura;
		}

		public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
			this.detallesFactura = detallesFactura;
		}


		public List<DetallePedido> getDetallesPedido() {
			return detallesPedido;
		}


		public void setDetallesPedido(List<DetallePedido> detallesPedido) {
			this.detallesPedido = detallesPedido;
		}
*/

		public String getDenominacion() {
			return denominacion;
		}

		public void setDenominacion(String denominacion) {
			this.denominacion = denominacion;
		}

		public double getPrecioCompra() {
			return precioCompra;
		}

		public void setPrecioCompra(double precioCompra) {
			this.precioCompra = precioCompra;
		}

		public double getPrecioVenta() {
			return precioVenta;
		}

		public void setPrecioVenta(double precioVenta) {
			this.precioVenta = precioVenta;
		}

		public double getStockActual() {
			return stockActual;
		}

		public void setStockActual(double stockActual) {
			this.stockActual = stockActual;
		}

		public double getStockMinimo() {
			return stockMinimo;
		}

		public void setStockMinimo(double stockMinimo) {
			this.stockMinimo = stockMinimo;
		}

		public String getUnidadMedida() {
			return unidadMedida;
		}

		public void setUnidadMedida(String unidadMedida) {
			this.unidadMedida = unidadMedida;
		}

		public boolean isEsInsumo() {
			return esInsumo;
		}

		public void setEsInsumo(boolean esInsumo) {
			this.esInsumo = esInsumo;
		}



		public String getImagen() {
			return imagen;
		}



		public void setImagen(String imagen) {
			this.imagen = imagen;
		}
		
		
		
		
   }	