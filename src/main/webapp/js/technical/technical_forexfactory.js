$("body").on('DOMSubtreeModified', "table.activity.trades_activity__table", function(e) {

	console.log("=============正在加载自动上报脚本================");

    jQuery.each($('table.activity.trades_activity__table tbody tr'), function(index, item) {
        var timeNow = parseInt($(this).find('span.nowrap').text().match(/\d+/));

        var order = $(this).find('p.trades_activity__overview').text().replace('/','').split(/\s+/);
        var orderStr = order.toString();

        if(!window.hasPushedOrder){
            window.hasPushedOrder = [];
        }
        console.log(window.hasPushedOrder);

        if(timeNow < 3 && !window.hasPushedOrder.includes(orderStr)){

            window.hasPushedOrder.push(orderStr);

            $.ajax({
                url:'https://localhost:8443/webhook/signal/forexfactory.json',
                dataType: 'jsonp',
                type: 'POST',
                data: { platform:'forexfactory', userName:$(this).find('span.username').text(), currency:order[1],price:order[3],type:order[2], time: timeNow},
                success:function(json){
                    console.log(json);
                }
            });
        }else{
            return false;
        }

        console.log(timeNow);
    });
});