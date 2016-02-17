/**
 * 获取新闻
 *
 * Created by lei on 16-1-10.
 */

$(document).ready(function(){
    //获取日历
    getCalendar();

    //根据重要性过滤日历
    $(".btn-group a").click(function () {
        filterCalendar($(this).text());
    });

});

/**
 * 获取财经日历
 */
function getCalendar(){
    $.ajax({
        type: "get",
        url: "/news/calendar.json",
        data: {"from":"", "to":""},
        success: function(data) {

            var tempTime = "";
            $.each(data.figure,function(index, value){
                var orginSection = $('.timeline li.animated-when-visible:last');

                var importance = "";
                switch (value.importance){
                    case "L": importance = '<span class="label label-success">低</span>';break;
                    case "M": importance = '<span class="label label-primary">中</span>';break;
                    case "H": importance = '<span class="label label-danger">高</span>';break;
                }

                if (tempTime == value.currency + value.time){
                    orginSection.find("tbody")
                        .append('<tr>' +
                            '<td class="col-md-6">'+value.country+value.period+value.event+'</td>' +
                            '<td>'+importance+'</td>' +
                            '<td>'+value.previous+'</td>' +
                            '<td>'+value.forecast+'</td>' +
                            '<td>'+value.actual+'</td>' +
                            '</tr>');
                }else{
                    var newsSection = orginSection.clone();

                    newsSection.removeClass("hidden");
                    newsSection.find("tbody tr").remove();
                    newsSection.find("tbody")
                        .append('<tr>' +
                            '<td>'+value.country+value.period+value.event+'</td>' +
                            '<td>'+importance+'</td>' +
                            '<td>'+value.previous+'</td>' +
                            '<td>'+value.forecast+'</td>' +
                            '<td>'+value.actual+'</td>' +
                            '</tr>');
                    newsSection.find(".timeline-footer span")
                        .html('<i class="glyphicon glyphicon-time"></i> '+ value.date + " " + value.time);
                    newsSection.insertAfter(orginSection);

                    tempTime = value.currency + value.time;
                }

            });
        }
    });
}

/**
 * 过滤显示事件
 * @param type
 */
function filterCalendar(type){

    $('.timeline li.animated-when-visible tbody tr span').each(function( index ) {

        if (type == "全部"){
            $($(this).parent().parent()).removeClass("hidden");
        }else if (type.indexOf($(this).text()) > -1){
            $($(this).parent().parent()).removeClass("hidden");
        }else {
            $($(this).parent().parent()).addClass("hidden");
        }
    });

    $('.timeline li.animated-when-visible').each(function( index ) {
        if ($( this ).find("tbody tr:not(.hidden)").size() < 1){
            $( this).addClass("hidden");
        }else {
            $( this).removeClass("hidden");
        }
    });

}