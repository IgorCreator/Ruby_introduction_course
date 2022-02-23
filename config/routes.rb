Rails.application.routes.draw do
  resources :articles
  root 'pages#home'
  get 'about', to: 'pages#about'
  get 'about_mozilla', to: 'pages#about_mozilla'
end
