Rails.application.routes.draw do
  root 'pages#home'
  get 'about', to: 'pages#about'
  get 'about_mozilla', to: 'pages#about_mozilla'
end
