/**
 * 技术分析
 *
 * Created by lei on 16-2-16.
 */

$(document).ready(function(){

    getTechnical();

    $('div.categories li a').click(function( event ) {
        $('div.categories li a').each(function( index ) {
            $( this).removeClass("disabled");
        });
        $(this).addClass('disabled');
    });
});

/**
 *  设置技术分析模块
 */
function getTechnical(){
    $.ajax({
        type: "get",
        url: "/technical/all.json",
        data: {"type":""},
        success: function(data) {
            var orginSection = $('#EURUSD li:last');
            var orginSectionSec = $('#AUDUSD li:last');

            //对时间段排序
            var array=[];
            for(a in data.userdata){
                array.push(data.userdata[a])
            }
            array.sort(function(a,b){
                return b.period - a.period
            });

            $.each(array,function(index, value){
                var newsSection = orginSection.clone();

                newsSection.find("span.category:eq(0)")
                    .text('移动平均指数: 买入 '+value.maBuy+' 卖出 '+value.maSell);
                newsSection.find("span.category:eq(1)")
                    .text('其他技术指标: 买入 '+value.tiBuy+' 卖出 '+value.tiSell);

                newsSection.find("span.label").removeClass().addClass("label");
                if (value.summary.indexOf("buy") > -1){
                    newsSection.find("span.label").addClass("label label-success");
                    newsSection.find("span.label").text("牛市");
                }else if(value.summary.indexOf("sell") > -1){
                    newsSection.find("span.label").addClass("label label-danger");
                    newsSection.find("span.label").text("熊市");
                }else {
                    newsSection.find("span.label").addClass("label label-info");
                    newsSection.find("span.label").text("中性");
                }

                if (value.produtcName == "eur-usd"){
                    newsSection.removeClass("hidden");
                    switch (value.period){
                        case 900: newsSection.find("h5")
                            .html('<a href="sub_technical.html">EUR/USD</a> 30分钟图');
                            break;
                        case 3600: newsSection.find("h5")
                            .html('<a href="sub_technical.html">EUR/USD</a> 小时图');
                            break;
                        case 86400: newsSection.find("h5")
                            .html('<a href="sub_technical.html">EUR/USD</a> 日线图');
                            break;
                    }
                    newsSection.insertAfter(orginSection);
                }
                if (value.produtcName == "aud-usd"){
                    newsSection.removeClass("hidden");
                    switch (value.period){
                        case 900: newsSection.find("h5")
                            .html('<a href="sub_technical.html">AUD/USD</a> 30分钟图');
                            break;
                        case 3600: newsSection.find("h5")
                            .html('<a href="sub_technical.html">AUD/USD</a> 小时图');
                            break;
                        case 86400: newsSection.find("h5")
                            .html('<a href="sub_technical.html">AUD/USD</a> 日线图');
                            break;
                    }
                    newsSection.insertAfter(orginSectionSec);
                }



            });
        }
    });
}