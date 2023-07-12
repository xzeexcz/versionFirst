function loadMoviesForAnother() {

    $.ajax({
        url: '/home/dtos',
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            var html1 = '';
            $('.lolka').owlCarousel('destroy');
            $('.lolka').owlCarousel({
                items: 4,
                merge: false, // Отключить объединение элементов
                loop: false, // Зациклить карусель
                nav: true, // Показывать навигационные кнопки
                dots: false, // Скрыть точки навигации
                margin: 30,
                responsive: {
                    0: {
                        items: 4 // Количество элементов на мобильных устройствах
                    },
                    768: {
                        items: 4 // Количество элементов на планшетах и десктопах
                    }
                }
            });

            for (var i = 12; i <= 15; i++) {
                var movie1 = response[i];
                html1 += '<div class="item">';
                html1 += '<div class="movie type-movie status-publish has-post-thumbnail hentry movie_genre-action movie_genre-adventure movie_genre-drama">';
                html1 += '<div class="gen-carousel-movies-style-2 movie-grid style-2">';
                html1 += '<div class="gen-movie-contain">';
                html1 += '<div class="gen-movie-img">';
                html1 += '<img src="" alt="owl-carousel-video-image">';
                html1 += '<div class="gen-movie-add">';
                html1 += '<div class="wpulike wpulike-heart">';
                html1 += '<div class="wp_ulike_general_class wp_ulike_is_not_liked">';
                html1 += '<button type="button" class="wp_ulike_btn wp_ulike_put_image">';
                html1 += '</button>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '<ul class="menu bottomRight">';
                html1 += '<li class="share top">';
                html1 += '<i class="fa fa-share-alt"></i>';
                html1 += '<ul class="submenu">';
                html1 += '<li><a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a></li>';
                html1 += '<li><a href="#" class="facebook"><i class="fab fa-instagram-f"></i></a></li>';
                html1 += '<li><a href="#" class="facebook"><i class="fab fa-twitter-f"></i></a></li>';
                html1 += '</ul>';
                html1 += '</li>';
                html1 += '</ul>';
                html1 += '<div class="movie-actions--link_add-to-playlist dropdown">';
                html1 += '<a class="dropdown-toggle" href="#" data-toggle="dropdown"><i class="fa fa-plus"></i></a>';
                html1 += '<div class="dropdown-menu mCustomScrollbar">';
                html1 += '<div class="mCustomScrollBox">';
                html1 += '<div class="mCSB_container">';
                html1 += '<a class="login-link" href="register.html">Sign in to add this movie to a playlist.</a>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '<div class="gen-movie-action">';
                html1 += '<a href="single-movie.html" class="gen-button"><i class="fa fa-play"></i></a>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '<div class="gen-info-contain">';
                html1 += '<div class="gen-movie-info">';
                html1 += '<h3><a href="single-movie.html">'+ movie1.movieSnippetDTO.title + '</a></h3>';
                html1 += '<div class="gen-movie-meta-holder">';
                html1 += '</div>';
                html1 += '<ul><li>2.00 hours</li><li><a href="action.html"><span>'+ movie1.genresDTOList.map(function (genres) { return genres.genreName;
                }).join(', ') + '</span></a></li></ul>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '</div>';
                html1 += '</div>';
                $('.lolka').owlCarousel('add', html1);
                html1 = '';
            }
            $('.lolka').owlCarousel('refresh');
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}