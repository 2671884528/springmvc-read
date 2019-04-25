
function findCategoryBooks(obj) {
    var category = obj.innerText;
    $.ajax({
        type:"POST",
        url:"/book/findBooks",
        data:{
            "category":category
        },
        success:function (data) {
            data = JSON.parse(data);
            var html = "";
            var book ;
            for(var i=0;i< data.books.length ;i++){
                book = data.books[i];
                html+= '<div class="text-box">\n' +
                    '                <div class="image">\n' +
                    '                    <a href="/chapter/toChapterList?bookId='+book.bookId+'"><img src="/static/images/49400s.jpg" width="90" height="120"></a>\n' +
                    '                </div>\n' +
                    '                <div class="book-message">\n' +
                    '                    <h4 class="book-name">\n' +
                    '                        <a href="/chapter/toChapterList?bookId='+book.bookId+'">'+book.bookName+'</a>\n' +
                    '                    </h4>\n' +
                    '                    <div class="book-author">\n' +
                    '                        作者：\n' +
                    '                        <a href="#">'+book.author+'</a>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>';
         }
         $("#books").html(html);
        },
        error:function (x,e,n) {
            console.log(x);
            console.log(e);
            console.log(n);
        }
    })
}
$(document).ready(function (){
    $("ul li").eq(0).click();
});

