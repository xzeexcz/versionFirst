function loadMovies() {
    var movieContainer = $('#cardso');

    $.ajax({
        url: '/home/dto',
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            var html = '';
            var itemCount = 0;
            var carousel = document.querySelector('.owl-carousel');
            for (var i = 12; i <= 14; i++) {
                var movie = response[i];
                itemCount += i;
                html += '<div class="item">';
                html += '<div class="gen-movie-contain-style-2 h-100">';
                html += '<div class="container h-100">';
                html += '<div class="row flex-row-reverse align-items-center h-100">';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-front-image">';
                html += '<img src="'+ movie.thumbnailsDTO.maxresThumbnail.url + '" alt="owl-carousel-banner-image">';
                html += '</div>';
                html += '</div>';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-tag-line"><span>Most Viewed</span></div>';
                html += '<div class="gen-movie-info">';
                html += '<h3>' + movie.movieSnippetDTO.title + '</h3>';
                html += '</div>';
                html += '<div class="gen-movie-meta-holder">';
                html += '<ul class="gen-meta-after-title">';
                html += '<li class="gen-sen-rating"><span>' + movie.movieSnippetDTO.rating + '</span></li>';
                html += '<li><img src="' + movie.thumbnailsDTO.defaultThumbnail.url + '" alt="rating-image"><span>' + movie.movieStatisticsDTO.viewsCount + '</span></li>';
                html += '</ul>';
                html += '<p>' + movie.movieSnippetDTO.description + '</p>';
                html += '<div class="gen-meta-info">';
                html += '<ul class="gen-meta-after-excerpt">';
                html += '<li><strong>Cast :</strong> ' + movie.castDTOList.map(function (cast) {
                    return cast.fullName;
                }).join(', ') + '</li>';
                html += '<li><strong>Genre :</strong> ' + movie.genresDTOList.map(function (genre) {
                    return '<span><a href="#">' + genre.genreName + '</a></span>';
                }).join(', ') + '</li>';
                html += '</ul>';
                html += '</div>';
                html += '</div>';
                html += '<div class="gen-movie-action">';
                html += '<div class="gen-btn-container">';
                html += '<a href="single-movie.html" class="gen-button .gen-button-dark">';
                html += '<i aria-hidden="true" class="fas fa-play"></i> <span class="text">Play Now</span>';
                html += '</a>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                // $('#movie-container').owlCarousel('add', '<div class="slide"><ul class="postcard_list">'+ html +'</ul></div>').owlCarousel('refresh');
                $('.carik').owlCarousel('add', html).owlCarousel('refresh');
            }
            carousel.dataset.desk_num = itemCount;
            movieContainer.html(html);
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}


function loadMovies() {
    var movieContainer = $('#movie-container');

    $.ajax({
        url: '/home/dto',
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            var html = '';
            var itemCount = 0;
            var carousel = document.querySelector('.owl-carousel');
            for (var i = 12; i <= 14; i++) {
                var movie = response[i];
                itemCount += i;
                html += '<div class="item">';
                html += '<div class="gen-movie-contain-style-2 h-100">';
                html += '<div class="container h-100">';
                html += '<div class="row flex-row-reverse align-items-center h-100">';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-front-image">';
                html += '<img src="'+ movie.thumbnailsDTO.maxresThumbnail.url + '" alt="owl-carousel-banner-image">';
                html += '</div>';
                html += '</div>';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-tag-line"><span>Most Viewed</span></div>';
                html += '<div class="gen-movie-info">';
                html += '<h3>' + movie.movieSnippetDTO.title + '</h3>';
                html += '</div>';
                html += '<div class="gen-movie-meta-holder">';
                html += '<ul class="gen-meta-after-title">';
                html += '<li class="gen-sen-rating"><span>' + movie.movieSnippetDTO.rating + '</span></li>';
                html += '<li><img src="' + movie.thumbnailsDTO.defaultThumbnail.url + '" alt="rating-image"><span>' + movie.movieStatisticsDTO.viewsCount + '</span></li>';
                html += '</ul>';
                html += '<p>' + movie.movieSnippetDTO.description + '</p>';
                html += '<div class="gen-meta-info">';
                html += '<ul class="gen-meta-after-excerpt">';
                html += '<li><strong>Cast :</strong> ' + movie.castDTOList.map(function (cast) {
                    return cast.fullName;
                }).join(', ') + '</li>';
                html += '<li><strong>Genre :</strong> ' + movie.genresDTOList.map(function (genre) {
                    return '<span><a href="#">' + genre.genreName + '</a></span>';
                }).join(', ') + '</li>';
                html += '</ul>';
                html += '</div>';
                html += '</div>';
                html += '<div class="gen-movie-action">';
                html += '<div class="gen-btn-container">';
                html += '<a href="single-movie.html" class="gen-button .gen-button-dark">';
                html += '<i aria-hidden="true" class="fas fa-play"></i> <span class="text">Play Now</span>';
                html += '</a>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                // $('#movie-container').owlCarousel('add', '<div class="slide"><ul class="postcard_list">'+ html +'</ul></div>').owlCarousel('refresh');
            }
            carousel.dataset.desk_num = itemCount;
            movieContainer.html(html);
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
} // работающий код

// $.ajax({
//     url: "/api/index.php?app=gifts&act=list",
//     success: function(data) {
//         var stat = data.code;
//
//         if (stat == '200') {
//
//             var photos = data.data;
//             $.each(photos, function(i, item) {
//                 var photo_item = '<div class="s"> <li data-card-cr="'+price+'" data-card-img="'+item.card_img+'" data-card-id="'+ item.card_id +'" data-card-name="'+item.card_name+'" data-card-usd="'+item.price_usd+'" ><img src="'+item.card_img+'"  class="postcard_image" /></li></div>';
//
//                 $('.postcard-main-c').owlCarousel('add', '<div class="slide"><ul class="postcard_list-m">'+ photo_item +'</ul></div>').owlCarousel('refresh');
//             });
//         }
//     })

function loadMovies() {
    var movieContainer = $('#cardso');

    $.ajax({
        url: '/home/dto',
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            var html = '';
            var itemCount = 0;
            var carousel = document.querySelector('.owl-carousel');
            $('.carik').owlCarousel({
                merge: false
            });

            for (var i = 12; i <= 14; i++) {
                var movie = response[i];
                itemCount += i;
                html += '<div class="item">';
                html += '<div class="gen-movie-contain-style-2 h-100">';
                html += '<div class="container h-100">';
                html += '<div class="row flex-row-reverse align-items-center h-100">';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-front-image">';
                html += '<img src="'+ movie.thumbnailsDTO.maxresThumbnail.url + '" alt="owl-carousel-banner-image">';
                html += '</div>';
                html += '</div>';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-tag-line"><span>Most Viewed</span></div>';
                html += '<div class="gen-movie-info">';
                html += '<h3>' + movie.movieSnippetDTO.title + '</h3>';
                html += '</div>';
                html += '<div class="gen-movie-meta-holder">';
                html += '<ul class="gen-meta-after-title">';
                html += '<li class="gen-sen-rating"><span>' + movie.movieSnippetDTO.rating + '</span></li>';
                html += '<li><img src="' + movie.thumbnailsDTO.defaultThumbnail.url + '" alt="rating-image"><span>' + movie.movieStatisticsDTO.viewsCount + '</span></li>';
                html += '</ul>';
                html += '<p>' + movie.movieSnippetDTO.description + '</p>';
                html += '<div class="gen-meta-info">';
                html += '<ul class="gen-meta-after-excerpt">';
                html += '<li><strong>Cast :</strong> ' + movie.castDTOList.map(function (cast) {
                    return cast.fullName;
                }).join(', ') + '</li>';
                html += '<li><strong>Genre :</strong> ' + movie.genresDTOList.map(function (genre) {
                    return '<span><a href="#">' + genre.genreName + '</a></span>';
                }).join(', ') + '</li>';
                html += '</ul>';
                html += '</div>';
                html += '</div>';
                html += '<div class="gen-movie-action">';
                html += '<div class="gen-btn-container">';
                html += '<a href="single-movie.html" class="gen-button .gen-button-dark">';
                html += '<i aria-hidden="true" class="fas fa-play"></i> <span class="text">Play Now</span>';
                html += '</a>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                // $('#movie-container').owlCarousel('add', '<div class="slide"><ul class="postcard_list">'+ html +'</ul></div>').owlCarousel('refresh');
                $('.carik').owlCarousel('add', html);
            }
            $('.carik').owlCarousel('refresh');
            carousel.dataset.desk_num = itemCount;
            // movieContainer.html(html);
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}

<div className="owl-carousel carik" id="cardso" data-margin="0" data-loop="true" data-desk_num="1">

</div>

function loadMovies() {
    var movieContainer = $('#cardso');

    $.ajax({
        url: '/home/dto',
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            var html = '';
            var itemCount = 0;
            var carousel = document.querySelector('.owl-carousel');
            $('.carik').owlCarousel('destroy');
            $('.carik').owlCarousel({
                merge: false, // Отключить объединение элементов
                loop: true, // Зациклить карусель
                nav: true, // Показывать навигационные кнопки
                dots: false, // Скрыть точки навигации
                responsive: {
                    0: {
                        items: 1 // Количество элементов на мобильных устройствах
                    },
                    768: {
                        items: 3 // Количество элементов на планшетах и десктопах
                    }
                }
            });

            for (var i = 12; i <= 14; i++) {
                var movie = response[i];
                itemCount += i;
                html += '<div class="item">';
                html += '<div class="gen-movie-contain-style-2 h-100">';
                html += '<div class="container h-100">';
                html += '<div class="row flex-row-reverse align-items-center h-100">';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-front-image">';
                html += '<img src="'+ movie.thumbnailsDTO.maxresThumbnail.url + '" alt="owl-carousel-banner-image">';
                html += '</div>';
                html += '</div>';
                html += '<div class="col-xl-6">';
                html += '<div class="gen-tag-line"><span>Most Viewed</span></div>';
                html += '<div class="gen-movie-info">';
                html += '<h3>' + movie.movieSnippetDTO.title + '</h3>';
                html += '</div>';
                html += '<div class="gen-movie-meta-holder">';
                html += '<ul class="gen-meta-after-title">';
                html += '<li class="gen-sen-rating"><span>' + movie.movieSnippetDTO.rating + '</span></li>';
                html += '<li><img src="' + movie.thumbnailsDTO.defaultThumbnail.url + '" alt="rating-image"><span>' + movie.movieStatisticsDTO.viewsCount + '</span></li>';
                html += '</ul>';
                html += '<p>' + movie.movieSnippetDTO.description + '</p>';
                html += '<div class="gen-meta-info">';
                html += '<ul class="gen-meta-after-excerpt">';
                html += '<li><strong>Cast :</strong> ' + movie.castDTOList.map(function (cast) {
                    return cast.fullName;
                }).join(', ') + '</li>';
                html += '<li><strong>Genre :</strong> ' + movie.genresDTOList.map(function (genre) {
                    return '<span><a href="#">' + genre.genreName + '</a></span>';
                }).join(', ') + '</li>';
                html += '</ul>';
                html += '</div>';
                html += '</div>';
                html += '<div class="gen-movie-action">';
                html += '<div class="gen-btn-container">';
                html += '<a href="single-movie.html" class="gen-button .gen-button-dark">';
                html += '<i aria-hidden="true" class="fas fa-play"></i> <span class="text">Play Now</span>';
                html += '</a>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                // $('#movie-container').owlCarousel('add', '<div class="slide"><ul class="postcard_list">'+ html +'</ul></div>').owlCarousel('refresh');
                $('.carik').owlCarousel('add', html);
                html = '';
            }
            $('.carik').owlCarousel('refresh');
            // movieContainer.html(html);
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}