var flag = false;
var flagFormAdd = false;
var flagFormEdit = false;
var flagFormDelete = false;
function show() {

    $.getJSON("/users",function(response){
        var tblHTML ='<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Age</th></tr>';
        $.each(response, function(i, item){
            tblHTML
                += '<tr><td>' + item.id + '</td><td>'+ item.firstName + '</td><td>'
                + item.lastName + '</td><td>' + item.age + '</td></tr>';
        });
        $('.users-table').html(tblHTML);
    });
}
$(document).ready(function () {

    show();
    setInterval('show()',500);

    $("#showUsers").click(function () {
        if(!flag){
            $('#tabU').css('display','table');
            //$('#row').css('display','table');
            flag = true;
        }else {
            $('#tabU').css('display', 'none');
            //$('#row').css('display','none');
            flag = false;
        }
    });

    $("#showAddForm").click(function () {
        if(!flagFormAdd){
            $('#formAdd').css('display','table');
            $('#formEdit').css('display', 'none');
            $('#formDelete').css('display', 'none');
            flagFormAdd = true;
            flagFormEdit = false;
            flagFormDelete = false;
        }else {
            $('#formAdd').css('display', 'none');
            $('#formEdit').css('display', 'none');
            $('#formDelete').css('display', 'none');
            flagFormAdd = false;
        }
    });

    $("#showEditForm").click(function () {
        if(!flagFormEdit){
            $('#formEdit').css('display','table');
            $('#formAdd').css('display', 'none');
            $('#formDelete').css('display', 'none');
            flagFormEdit = true;
            flagFormAdd = false;
            flagFormDelete = false;
        }else {
            $('#formEdit').css('display', 'none');
            $('#formAdd').css('display', 'none');
            $('#formDelete').css('display', 'none');
            flagFormEdit = false;
        }
    });

    $("#showDeleteForm").click(function () {
        if(!flagFormDelete){
            $('#formDelete').css('display','table');
            $('#formEdit').css('display','none');
            $('#formAdd').css('display', 'none');
            flagFormDelete = true;
            flagFormEdit = false;
            flagFormAdd = false;
        }else {
            $('#formDelete').css('display', 'none');
            $('#formEdit').css('display', 'none');
            $('#formAdd').css('display', 'none');
            flagFormDelete = false;
        }
    });

    $("#addData").click(function () {
        $.ajax({
            url: 'http://localhost:8080/users',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify( { "firstName": $('#inputAddFirstName').val(),
                                    "lastName": $('#inputAddSecoundName').val(),
                                    "age": $('#inputAddAge').val()  } ),
            success: true
        });
    });

    $("#deleteData").click(function () {
        $.ajax({
            url: 'http://localhost:8080/users/' + $('#inputDeleteId').val(),
            type: 'DELETE',
            success: true
        });
    });

    $("#editData").click(function () {
        $.ajax({
            url: 'http://localhost:8080/users/' + $('#inputEditId').val(),
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify( { "firstName": $('#inputEditFirstName').val(),
                                    "lastName": $('#inputEditSecoundName').val(),
                                    "age": $('#inputEditAge').val(),
                                    "id": $('#inputEditId').val()})
        });
    });
});