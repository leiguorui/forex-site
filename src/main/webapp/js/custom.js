/*  
* Custom JS
*/
$(document).ready(function(){
/*	Tooltip
/*----------------------------------------------------*/
	$('.tip').tooltip();
	
/*	Scroll To Top
/*----------------------------------------------------*/
	$('.to-top a').click(function () { 
		$('body,html').animate({scrollTop: 0 }, 800);
		return false;
	});	

/*	prettyPhoto
/*----------------------------------------------------*/
	$("a[rel^='prettyPhoto']").prettyPhoto({social_tools: ''});

/*	Loading Btn
/*----------------------------------------------------*/	
$('.btn-load').click(function () {
	var btn = $(this)
	btn.button('loading')
    setTimeout(function () {
		btn.button('reset')
    }, 3000)
});



/*	Bx Slider
/*----------------------------------------------------*/
	var pause = 3000, speed = 500, prozent = 1, limit = 100, diff = 0;
				
	//Progress Animation
	var progress = function () {
		if(prozent != limit) {
			$('#progressbar').animate({
				width: ++prozent+"%"
			}, 0, 'linear', function () {
				setTimeout(progress, (pause/limit)-(diff/limit));
				});    
			} else {
				$('#progressbar').css({width: '0%'});
			}
	};
	
	$('.bxslider').bxSlider({
		nfiniteLoop: true,
		controls: false, 
		mode: 'vertical',
		pagerCustom: '#bx-tabs',
		auto: true,
		onSliderLoad: function () {
			progress();
		},
		onSlideAfter: function () {
			prozent = 1;
			progress();
		},
				
		onSlideBefore: function (currentSlideNumber, totalSlideQty, currentSlideHtmlObject) {
			console.log(currentSlideHtmlObject);
			$('.img img').removeClass('animated bounce');
			$('.title h2').removeClass('animated fadeInLeft');
			$('.title h1').removeClass('animated fadeInRight');
			$('.title p').removeClass('animated fadeInLeft');
			$('.title h2').eq(currentSlideHtmlObject + 1).addClass('animated fadeInLeft');
			$('.title h1').eq(currentSlideHtmlObject + 1).addClass('animated fadeInRight');
			$('.title p').eq(currentSlideHtmlObject + 1).addClass('animated fadeInLeft');
			$('.img img').eq(currentSlideHtmlObject + 1).addClass('animated bounce');
		}
	});
  
/*	Image Hover
/*----------------------------------------------------*/
	$( ".img" ).hover(
		function() {
			$(this).find("i").addClass('animated bounce');
		}, 
		function() {
			$(this).find("i").removeClass('animated bounce');
		}
	);
	
/*	Fixed Navigation
/*----------------------------------------------------*/	
	$(window).scroll(function(){
        if ($(this).scrollTop() > 10) {
            $('#sub-navigation').addClass('menu-shadow');
			$('.to-top').removeClass('display-none');
        } else {
			$('#sub-navigation').removeClass('menu-shadow');
			$('.to-top').addClass('display-none');
        }
    });
});

/* Modal Effects
/*----------------------------------------------------*/
$('.modal').on('shown.bs.modal', function (e) {
  $('.modal').addClass('animated flipInY');
});

$('.modal').on('hidden.bs.modal', function (e) {
  $('.modal').removeClass('animated flipInY');
});

/*	Dropdown Navigation
/*----------------------------------------------------*/
jQuery('#navigation li.dropdown').hover(function() {
  jQuery(this).find('.dropdown-menu').stop(true, true).show();
}, function() {
  jQuery(this).find('.dropdown-menu').stop(true, true).hide();
});
     