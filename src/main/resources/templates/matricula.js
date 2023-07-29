const url = "api/matricula";
var metodo="";

function save(bandera) {
    $("#modal-update").modal("hide")
    let id = $("#guardar").data("id");    
    let matricula = {
        id: id,
        
        Alumno : {
			id: $("#alumno_id").val()
		} , 
		
		Aula : {
			id: $("#numero_id").val()
		} , 
		
		Horario : {
			id: $("#dia_id").val()
		} , 
		
        fechamatricula:$("#fechamatricula").val(),
        
        docente : {
			id: $("#docente_id").val()
		} 
    }
    let metodo = bandera == 1 ? "POST" : "PUT";
    $.ajax({
        type: metodo,
        url: url,
        data: JSON.stringify(matricula),
        dataType: "text",
        contentType: "application/json",
        cache: false,
        success: function (data) {
			if(data==0){
				Swal.fire({
	                icon: 'error',
	                title: 'La matricula ya esta registrado',
	                showConfirmButton: false,
	                timer: 1500
	            })				
			}else{
	            let texto = bandera == 1 ? "guardado": "actualizado";
	            getTabla();
	            Swal.fire({
	                icon: 'success',
	                title: 'Se ha '+texto+' la matricula',
	                showConfirmButton: false,
	                timer: 1500
	            })
	            clear();
            }
        },
    }).fail(function () {
        
    });
}

function deleteFila(id) {
    $.ajax({
        type: "DELETE",
        url: url+"/"+id,
        data: {
            id: id,
        },
        cache: false,
        timeout: 600000,
        success: function (data) {
            Swal.fire({
                icon: 'success',
                title: 'Se ha eliminado la matricula',
                showConfirmButton: false,
                timer: 1500
            });
            getTabla();
        },
    }).fail(function () {

    });

}

function getTabla() {
    $.ajax({
        type: "GET",
        url: url,
        dataType: "text",
        cache: false,
        success: function (data) {

            let t = $("#tablaMatricula").DataTable();
            t.clear().draw(false);

            let botonera = '<button type="button" class="btn btn-warning btn-sm editar"><i class="fas fa-edit"></i> </button>' +
                '<button type="button" class="btn btn-danger btn-sm eliminar"><i class="fas fa-trash"></i></button>';

            let js = JSON.parse(data);

            $.each(js, function (a, b) {
                t.row.add([b.id, b.alumno.nombre, b.alumno.apellidopaterno, b.alumno.apellidomaterno,b.aula.numero,b.horario.dia,b.fechamatricula,b.docente.nombre, botonera]);

            });

            t.draw(false);

        },
    }).fail(function () {

    });
}


function getFila(id) {

    $.ajax({
        type: "GET",
        url: url +"/"+id,
        data: {
            id: id,
        },
        cache: false,
        timeout: 600000,
        success: function (data) {
            $("#modal-title").text("Editar Alumno");
           
            $("#nombre").val(data.alumno.nombre);
            $("#apellidopaterno").val(data.alumno.apellidopaterno);
            $("#apellidomaterno").val(data.alumno.apellidomaterno);
            
            $("#aula").val(data.aula.numero);
            $("#horario").val(data.horario.dia);
            
            $("#fechamatricula").val(data.fechamatricula);
           
            $("#docente_id").val(data.docente.id);
            $("#guardar").data("id", data.id);
            $("#guardar").data("bandera", 0);
            $("#modal-update").modal("show");
        },
    }).fail(function () {

    });
}

function clear() {
    $("#modal-title").text("Nueva Matricula");
    $("#nombre").val("");
    $("#guardar").data("id", 0);
    $("#guardar").data("bandera", 1);
}
function getSelect(){
	$.ajax({
        type: "GET",
        url: url+"/selectAlumno",
        cache: false,
        timeout: 600000,
        success: function (data) {
			$("#Alumno_id").empty();
			for( var i = 0; i<data.length; i++){
				var id = data[i]['id'];
				var nombre = data[i]['nombre'];	
				var apellidopaterno = data[i]['apellidopaterno'];	
				var apellidomaterno = data[i]['apellidomaterno'];
				$("#Alumno_id").append("<option value='"+id+"'>"+nombre+"</option>");
				$("#Alumno_id").append("<option value='"+id+"'>"+apellidppaterno+"</option>");
				$("#Alumno_id").append("<option value='"+id+"'>"+apellidomaterno+"</option>");	
			}
        },
    }).fail(function () {
        
    });
}

function getSelect(){
	$.ajax({
        type: "GET",
        url: url+"/selectDocente",
        cache: false,
        timeout: 600000,
        success: function (data) {
			$("#docente_id").empty();
			for( var i = 0; i<data.length; i++){
				var id = data[i]['id'];
				var nombre = data[i]['nombre'];				
				$("#docente_id").append("<option value='"+id+"'>"+nombre+"</option>");	
			}
        },
    }).fail(function () {
        
    });
}
$(document).ready(function () {

    $("#tablaMatricula").DataTable({
        language: {
            lengthMenu: "Mostrar _MENU_ registros",
            zeroRecords: "No se encontraron alumnos",
            info: "Mostrando del _START_ al _END_ DE _TOTAL_",
            infoEmpty: "Sin resultados",
            search: "Buscar: ",
            paginate: {
                first: "Primero",
                last: "Último",
                next: "Siguiente",
                previous: "Anterior",
            },
        },
        columnDefs: [
            { targets: 0, width: "10%" },
            { targets: 1, width: "80%" },
            { targets: 2, orderable: false, width: "10%" }
        ],
    });

    clear();

    $("#nuevo").click(function () {
        clear();
    });

    $("#guardar").click(function () {

        let bandera = $("#guardar").data("bandera");
        save(bandera);
    })

    $(document).on('click', '.eliminar', function () {
        Swal.fire({
            title: 'Eliminar Alumno',
            text: "¿Esta seguro de querer eliminar este Alumno?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si'
        }).then((result) => {
            if (result.isConfirmed) {
                let id = $($(this).parents('tr')[0].children[0]).text();
                deleteFila(id);
            }
        })
    });

    $(document).on('click', '.editar', function () {
        let id = $($(this).parents('tr')[0].children[0]).text();
        getFila(id);
    });
    getTabla();
     getSelect();
});