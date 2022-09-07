var main = {
    init: function() {
        var _this = this;

        //let saveBtn = document.getElementById('btn-save');
        //let saveBtn2 = document.querySelctor('#btn-save');
        $('#btn-save').on('click', function(){
            _this.save();
        });

    },

    save: function() {
        // RE 검사..
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        })
        .done(function(){
            alert('글이 등록되었습니다.');
            location.href='/';
        })
        .fail(function(error){
            alert('글쓰기 에러입니다.');
            alert(JSON.stringify(error));
        })
    }
}

main.init();