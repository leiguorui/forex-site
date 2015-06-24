/*!
 * jQuery Cookie Plugin v1.3
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2011, Klaus Hartl
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.opensource.org/licenses/GPL-2.0
 */
(function ($, document, undefined) {

	var pluses = /\+/g;

	function raw(s) {
		return s;
	}

	function decoded(s) {
		return decodeURIComponent(s.replace(pluses, ' '));
	}

	var config = $.cookie = function (key, value, options) {

		// write
		if (value !== undefined) {
			options = $.extend({}, config.defaults, options);

			if (value === null) {
				options.expires = -1;
			}

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setDate(t.getDate() + days);
			}

			value = config.json ? JSON.stringify(value) : String(value);

			return (document.cookie = [
				encodeURIComponent(key), '=', config.raw ? value : encodeURIComponent(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// read
		var decode = config.raw ? raw : decoded;
		var cookies = document.cookie.split('; ');
		for (var i = 0, parts; (parts = cookies[i] && cookies[i].split('=')); i++) {
			if (decode(parts.shift()) === key) {
				var cookie = decode(parts.join('='));
				return config.json ? JSON.parse(cookie) : cookie;
			}
		}

		return null;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		if ($.cookie(key) !== null) {
			$.cookie(key, null, options);
			return true;
		}
		return false;
	};

})(jQuery, document);


/*-----------------------------------------------------------------------------------
/* Style Switcher
-----------------------------------------------------------------------------------*/

window.console = window.console || (function(){
	var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile = c.clear = c.exception = c.trace = c.assert = function(){};
	return c;
})();


$(document).ready(function(){ 

$('#styleswitcher h2 a').click(function(e){
	e.preventDefault();
	var div = $('#styleswitcher');
	console.log(div.css('left'));
	if (div.css('left') === '-180px') {
			$('#styleswitcher').animate({
			left: '0px'
	}); 
	} else {
		$('#styleswitcher').animate({
			left: '-180px'
		});
	}
})

/* Layout Style */
var cookieName = 'layout';

function changeLayout(layoutid) {
$.cookie(cookieName, layoutid);
	$('head link[id=layout]').attr('href', 'css/' + layoutid + '.css');
}

if( $.cookie(cookieName)) {
	changeLayout($.cookie(cookieName));
}

$("#wide").click( function(){ $
	changeLayout('wide');
});

$("#boxed").click( function(){ $
	changeLayout('boxed');
});
});

$(document).ready(function(){ 

/* Colors */
var cookieName = 'colors';

function changeLayout(colorsid) {
$.cookie(cookieName, colorsid);
	$('head link[id=colors]').attr('href', 'css/colors/' + colorsid + '.css');
}

if( $.cookie(cookieName)) {
	changeLayout($.cookie(cookieName));
}

$(".green").click( function(){ $
	changeLayout('green');
});

$(".blue").click( function(){ $
	changeLayout('blue');
});

$(".red").click( function(){ $
	changeLayout('red');
});

$(".pink").click( function(){ $
	changeLayout('pink');
});
		
});

