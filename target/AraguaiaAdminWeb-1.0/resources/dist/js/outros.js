$(document).ready(function() {
    $.mask.definitions['~'] = '[+-]';
    $('.input-mask-date').mask('99/99/9999');
    $('.input-mask-phone').mask('(99) 9999-9999');
    $('.input-mask-cpf').mask('999.999.999-99');
    $('.input-mask-cnpj').mask('99.999.999/9999-99');
    $('.input-mask-rg').mask('99.99.999');
    $('.input-mask-cep').mask('99999-999');
    $('.input-mask-agencia').mask('9999-9');
    $('.input-mask-conta').mask('99.999-9');
    $('.input-mask-placa').mask('aaa-9999');
    $('.input-mask-int1').mask('9');
    $('.input-mask-int2').mask('9?9');
    $('.input-mask-int3').mask('999');
    $('.input-mask-int4').mask('9999');
    $('.input-mask-int5').mask('9?9999');
    $('.input-mask-int9').mask('999999999');
    $('.input-mask-int10').mask('9999999999');
    $('.input-mask-eyescript').mask('~9.99 ~9.99 999');
    $(".input-mask-product").mask("a*-999-a999", {placeholder: " ", completed: function() {
            alert("You typed the following: " + this.val());
        }});    
});