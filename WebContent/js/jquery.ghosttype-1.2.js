/*
 ghostType v1.2 [March 19, 2011]
 http://ghosttype.com
 by William Moynihan

 ghostType jQuery Plugin
 -----------------------
 Use: Add text within an object of your document and call the ghostType function.

 Ex: $("#mydiv").ghostType();

 (It is recommended that you add the "display: none" CSS property to the object.)

 ghostType reserves the "^" character to create a delay between portions of your text.
 You can use this to simulate a more natural typing effect, such as delays between
 displaying sentences.

 Ex: <div id="mydiv">Welcome to my website.^^^^^^^^^^ I've been expecting you!</div>

 With a default delay setting of 100ms the above example will add a 1 second delay
 before displaying the second sentence. "^" characters will be removed.
 */

(function($) {
	$.fn.ghostType = function() {

		return this.each(function() {

			var $this = $(this);
			var str = $this.text();
			$this.empty().show();
			str = str.split("");
			// str.push("_");
			console.log(str.length);
			// increase the delay to ghostType slower
			var delay = 100;

			$.each(str, function(i, val) {

				if (val == "^") {
					// Do nothing. This will add to the delay.
				} else {
					$this.append('<span>' + val + '</span>');
					$this.children("span").hide().fadeIn(100).delay(delay * i);

				}
			});
			// $this.children("span:last").css("textDecoration", "blink");

		});

		$('#ghostType').append("<button>A</button>");
	};

})(jQuery);