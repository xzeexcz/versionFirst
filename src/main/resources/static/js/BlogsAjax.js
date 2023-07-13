function loadBlogs() {
    $.ajax({
        url: '/blogs/all',
        type: 'GET',
        dataType: 'json',
        async:false,
        success: function(response) {
            var html = '';
            for (var i = 0; i <= 5 ; i++) {
                var blog = response[i];
                html += '<div class="col-lg-12">';
                html += '<div class="gen-blog-post">';
                html += '<div class="gen-blog-contain">';
                html += '<div class="gen-post-meta">';

                html += '<ul>';
                html += '<li class="gen-post-author"><i class="fa fa-user"></i>' + blog.author.firstName + '</li>';
                html += '<li class="gen-post-meta"><i class="fa fa-calendar"></i>'+ blog.postDate +'</li>';
                html += '<li><i class="fa fa-tag"></i>'+ blog.categoriesList.map(function (name) { return name.categoryName}).join(", ") +'</li>';
                html += '</ul>';
                html += '</div>';

                html += '<h5 class="gen-blog-title"><a href="blog-single.html">'+ blog.title +'</a></h5>';
                html += '<p>'+ blog.description+ '</p>';

                html += '<div><a class="gen-button" onclick="blogDetails('+blog.id+')"><div class="gen-button-block"><span class="gen-button-text">Read More</span></div></a></div>'

                html += '</div>'; // третий
                html += '</div>'; // второй
                html += '</div>'; // первый
                $('.blog').append(html);
                html = '';


            }
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}
