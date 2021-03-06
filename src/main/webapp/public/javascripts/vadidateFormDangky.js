$(document).ready(function(e) {

    jQuery.validator.addMethod("user", function(value, element) {
        return this.optional(element) || /^[A-Za-z0-9_\.]{8,32}$/g.test(value);
    }, "User chưa hợp lệ (Chỉ bao gồm a-Z 0-9 _ . và từ 8-32 ký tự)");

    $("#kt").validate({
        rules:{
        	userName:{
                required:true,
                user: true 
                
            },
            pass:{
                required: true,
                minlength: 8,
                maxlength: 32,
            },
            txtrepass:{
                required:true,
                equalTo: "#pass",
            },
            nameCus:{
                required:true
            },
            phone:{
                required: true,
                number: true,
                digits: true,
                maxlength: 10,
                minlength: 10,
            },
            email:{
                required: true,
                email: true,
            },
        },
        messages:{
        }
    });
});