/**
 * 获取新闻
 *
 * Created by lei on 16-1-10.
 */

$(document).ready(function(){
    $.ajax({
        type: "post",
        url: "/news/type.json",
        data: {"type":"", "pageNo":"1", "pageSize":"10"},
        success: function(data) {
            var orginSection = $('#wrapper .col-md-8 .padding section.clearfix:eq(0)');

            $.each(data.userdata.list.reverse(),function(index, value){
                var newsSection = orginSection.clone();
                newsSection.css("display", "");
                newsSection.find("h4").text(value.title);
                newsSection.find("img").attr("src", value.imageUrl);
                newsSection.find("p").text(value.content);
                newsSection.find(".details").html('<i class="fa fa-calendar-o"></i> ' + value.time);

                newsSection.insertAfter(orginSection);
            });
        }
    });
});
