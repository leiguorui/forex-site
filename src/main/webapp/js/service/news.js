/**
 * 获取新闻
 *
 * Created by lei on 16-1-10.
 */

$(document).ready(function(){
    var newsType = "";
    var newsPageNo = 1;
    var newsPageSize = 10;

    //加载新闻
    getNews(newsType, newsPageNo, newsPageSize);

    //更多新闻
    $('.btn-load').click(function () {
        newsPageNo++;

        var btn = $(this);
        btn.button('loading');
        getNews(newsType, newsPageNo, newsPageSize);
        btn.button('reset');
    });

    $('.section-categories a').click(function( event ) {
        event.preventDefault();

        $('.section-categories a').each(function( index ) {
            $( this).removeClass();
        });

        //加载指定货币对的新闻
        $(this).addClass('active');
        newsType = $(this).text() == "全部" ? "" : $(this).text();
        newsPageNo = 1;
        $('#wrapper .col-md-8 .padding section.clearfix').each(function( index ) {
            if ($(this).css('display') != 'none'){
                $( this).remove();
            }
        });
        getNews(newsType, newsPageNo, newsPageSize);
    });
});

/**
 * ajax请求新闻
 * @param type
 * @param pageNo
 * @param pageSize
 */
function getNews(type, pageNo, pageSize){
    $.ajax({
        type: "post",
        url: "/news/type.json",
        data: {"type":type, "pageNo":pageNo, "pageSize":pageSize},
        success: function(data) {
            var orginSection = $('#wrapper .col-md-8 .padding section.clearfix:last');

            $.each(data.userdata.list,function(index, value){
                var newsSection = orginSection.clone();
                newsSection.css("display", "");
                newsSection.find("h4").text(value.title);
                newsSection.find("img").attr("src", value.imageUrl);
                newsSection.find("p").text(value.content);
                newsSection.find(".details").html('<i class="fa fa-calendar-o"></i> ' + value.time+
                    '<span class="fa fa-caret-right"></span>'+
                    '<i class="glyphicon glyphicon-link"></i>来自 '+value.source);

                newsSection.insertAfter(orginSection);
            });
        }
    });
}