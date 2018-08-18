var flag = false;
$(document).ready(function () {

    $("#showUsers").click(function () {
        $.getJSON("/users",function(response){
            var tblHTML ='<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Age</th></tr>';
            $.each(response, function(i, item){
                tblHTML += '<tr><td>' + item. '</td><td>'+ item.firstName + '</td><td>'
                    + item.lastName + '</td><td>' + item.age + '</td></tr>';
            });
            $('.users-table').html(tblHTML);
            if(!flag){
                $('#tab').css('display','table');
                $('#row').css('display','table');
                flag = true;
            }else {
                $('#tab').css('display', 'none');
                $('#row').css('display','none');
                flag = false;
            }
        });
    });


   /* $('#showUsers').click(function () {
        if(!flag){
            $('#form').css('display','table');
            $('#tab').css('display','table');
            flag = true;
        }else {
            $('#tab').css('display','none');
           $('#form').css('display','none');
            flag = false;
        }
    })*/
});