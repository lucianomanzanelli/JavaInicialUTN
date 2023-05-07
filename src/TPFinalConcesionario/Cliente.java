package TPFinalConcesionario;


public class Cliente {
        
        private int id_cliente;
        private int dni;
        private String nombre;
        private String apellido;
        private String contacto;
        
        
        public Cliente() {
        	this.dni = 0;
        	this.nombre = "";
            this.apellido = "";
            this.contacto = "";
		}

		public int getId_cliente() {
            return id_cliente;
        }
        
        public void setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
        }
        
        public int getDni() {
            return dni;
        }
        
        public void setDni(int dni) {
            this.dni = dni;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        public String getApellido() {
            return apellido;
        }
        
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        
        public String getContacto() {
            return contacto;
        }
        
        public void setContacto(String contacto) {
            this.contacto = contacto;
        }
    }
