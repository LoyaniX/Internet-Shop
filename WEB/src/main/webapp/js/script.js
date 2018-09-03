var flagFormAddProd = false;
var flagFormEditProd = false;
var flagFormDeleteProd = false;
var flagFormAdd = false;
var flagFormEdit = false;
var flagFormDelete = false;
var flagFormAddOrder = false;
var flagFormEditOrder = false;
var flagFormDeleteOrder = false;

function show() {

    $.getJSON("/users",function(response){
        var tblHTML ='<tr><th>ID</th><th>Имя</th><th>Фамилия</th><th>Возраст</th></tr>';
        $.each(response, function(i, item){
            tblHTML
                += '<tr><td>' + item.id + '</td><td>'+ item.firstName + '</td><td>'
                + item.lastName + '</td><td>' + item.age + '</td></tr>';
        });
        $('.users-table').html(tblHTML);
    });

    $.getJSON("/orders",function(response){
        var tblHTML ='<tr><th>ID</th><th>Пользователь</th><th>Продукты(цена)</th><th>Итоговая цена</th><th>Дата заказа</th><th>Статус</th>';
        $.each(response, function (i, ord) {
            tblHTML += '<tr><td>' + ord.id + '</td><td>' + ord.user.firstName + " " + ord.user.lastName + '</td><td>';
            $.each(ord.products, function (pi, prod) {
                tblHTML += prod.name + "(" + prod.price + ")" + '<br>';
            });
            tblHTML += '</td><td>' + ord.orderPrice + '</td><td>' + new Date(ord.dateOfCreate).toLocaleDateString() + '</td><td>' + ord.status + '</td></tr>';
        });
        $('.order-table').html(tblHTML);
    });
    $.getJSON("/products",function(response){
        var tblHTML ='<tr><th>ID</th><th>Наименование</th><th>Цена</th><th>Категория</th>' +
            '<th>Пол</th><th>Цвет</th><th>Размер</th><th>Количество</th></tr>';
        $.each(response, function(i, item){
            tblHTML += '<tr><td>' + item.id + '</td><td>'+ item.name + '</td>' +
                '<td>' + item.price + '</td><td>' + item.category + '</td>' +
                '<td>'+ item.gender + '</td><td>'+ item.colour + '</td>' +
                '<td>'+ item.size + '</td><td>'+ item.quantity + '</td></tr>';
        });
        $('.product-table').html(tblHTML);
    });
}
function showOrders(){
    $.getJSON("/users",function(response){
        var select = document.getElementById('inputUser');
        while (select.options.length > 0){
            select.options.remove(0);
        }
        $.each(response, function(i, item){
                $('#inputUser').append('<option value="' + item.id +'">' + item.firstName + " " + item.lastName + '</option>');
        });
    });
    $.getJSON("/products",function(response){
        var select = document.getElementById('inputProducts');
        while (select.options.length > 0){
            select.options.remove(0);
        }
        $.each(response, function(i, item){
            $('#inputProducts').append('<option value="' + item.id +'">' + item.name + " (" + item.price + ")" + '</option>');
        });
    });
}

$(document).ready(function () {

    show();
    setInterval('show()',500);

    $("#showUsers").click(function () {
        $('#tabU').css('display','table');
        $('#tabO, #helloPage, #tabP').css('display','none');
    });

    $("#showProducts").click(function () {
        $('#tabP').css('display','table');
        $('#tabO, #helloPage, #tabU').css('display', 'none');
    });

    $("#showOrders").click(function () {
        showOrders();
        $('#tabO').css('display','table');
        $('#tabP, #helloPage, #tabU').css('display','none');
    });

    $("#mainButton").click(function () {
        $('#helloPage').css('display','table');
        $('#tabU, #tabP, #tabO').css('display','none');
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
            url: '/users',
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
            url: '/users/' + $('#inputDeleteId').val(),
            type: 'DELETE',
            success: true
        });
    });

    $("#editData").click(function () {
        $.ajax({
            url: '/users/' + $('#inputEditId').val(),
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify( { "firstName": $('#inputEditFirstName').val(),
                                    "lastName": $('#inputEditSecoundName').val(),
                                    "age": $('#inputEditAge').val(),
                                    "id": $('#inputEditId').val()})
        });
    });

    $("#showAddFormProd").click(function () {
        if(!flagFormAddProd){
            $('#formAddProd').css('display','table');
            $('#formEditProd').css('display', 'none');
            $('#formDeleteProd').css('display', 'none');
            flagFormAddProd = true;
            flagFormEditProd = false;
            flagFormDeleteProd = false;
        }else {
            $('#formAddProd').css('display', 'none');
            $('#formEditProd').css('display', 'none');
            $('#formDeleteProd').css('display', 'none');
            flagFormAddProd = false;
        }
    });

    $("#showEditFormProd").click(function () {
        if(!flagFormEditProd){
            $('#formEditProd').css('display','table');
            $('#formAddProd').css('display', 'none');
            $('#formDeleteProd').css('display', 'none');
            flagFormEditProd = true;
            flagFormAddProd = false;
            flagFormDeleteProd = false;
        }else {
            $('#formEditProd').css('display', 'none');
            $('#formAddProd').css('display', 'none');
            $('#formDeleteProd').css('display', 'none');
            flagFormEditProd = false;
        }
    });

    $("#showDeleteFormProd").click(function () {
        if(!flagFormDeleteProd){
            $('#formDeleteProd').css('display','table');
            $('#formEditProd').css('display','none');
            $('#formAddProd').css('display', 'none');
            flagFormDeleteProd = true;
            flagFormEditProd = false;
            flagFormAddProd = false;
        }else {
            $('#formDeleteProd').css('display', 'none');
            $('#formEditProd').css('display', 'none');
            $('#formAddProd').css('display', 'none');
            flagFormDeleteProd = false;
        }
    });

    $("#addDataProd").click(function () {
        $.ajax({
            url: '/products',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify( { "name": $('#inputAddNameProd').val(),
                "price": $('#inputAddPriceProd').val(),
                "category": $('#inputAddCategoryProd').val(),
                "gender": $('#inputAddGenderProd').val(),
                "colour": $('#inputAddColorProd').val(),
                "size": $('#inputAddSizeProd').val(),
                "quantity": $('#inputAddQuantityProd').val() } ),
            success: true
        });
    });

    $("#deleteDataProd").click(function () {
        $.ajax({
            url: '/products/' + $('#inputDeleteIdProd').val(),
            type: 'DELETE',
            success: true
        });
    });

    $("#editDataProd").click(function () {
        $.ajax({
            url: '/products/' + $('#inputEditIdProd').val(),
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify( { "id": $('#inputEditIdProd').val,
                "name": $('#inputEditNameProd').val(),
                "price": $('#inputEditPriceProd').val(),
                "category": $('#inputEditCategoryProd').val(),
                "gender": $('#inputEditGenderProd').val(),
                "colour": $('#inputEditColorProd').val(),
                "size": $('#inputEditSizeProd').val(),
                "quantity": $('#inputEditQuantityProd').val()})
        });
    });

    $("#showAddFormOrd").click(function () {
        showOrders();
        if(!flagFormAddOrder){
            $('#formAddOrder').css('display','table');
            flagFormAddOrder = true;
        }else {
            $('#formAddOrder').css('display', 'none');
            flagFormAddOrder= false;
        }
    });

    $("#addDataOrder").click(function () {
        var stringUser = (function () {
            var json = null;
            $.ajax({
                'async': false,
                'global': false,
                'url': '/users/' + $('#inputUser').val(),
                'dataType': "json",
                'success': function (data) {
                    json = data;
                }
            });
            return json;
        })();
        var stringProducts = '[';
        for(var i = 0; i < $('#inputProducts').val().length; i++ ){
            var buff = (function () {
                var json = null;
                $.ajax({
                    'async': false,
                    'global': false,
                    'url': '/products/' + $('#inputProducts').val()[i],
                    'dataType': "json",
                    'success': function (data) {
                        json = data;
                    }
                });
                return json;
            })();
            stringProducts += JSON.stringify(buff) + ",";
        }
        stringProducts = stringProducts.slice(0, -1);
        stringProducts = stringProducts + "]";
        stringProducts = JSON.parse(stringProducts);
        $.ajax({
            url: '/orders',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify( {
                            "user": stringUser,
                            "products": stringProducts,
                            "orderPrice": 1,
                            "dateOfCreate": "2018-08-30",
                            "status": "Created"
                } ),
            success: true
        });
    });
});