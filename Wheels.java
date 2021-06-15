<?php
// Exit if accessed directly
if ( !defined( 'ABSPATH' ) ) exit;

// BEGIN ENQUEUE PARENT ACTION
// AUTO GENERATED - Do not modify or remove comment markers above or below:

if ( !function_exists( 'chld_thm_cfg_locale_css' ) ):
    function chld_thm_cfg_locale_css( $uri ){
        if ( empty( $uri ) && is_rtl() && file_exists( get_template_directory() . '/rtl.css' ) )
            $uri = get_template_directory_uri() . '/rtl.css';
        return $uri;
    }
endif;
add_filter( 'locale_stylesheet_uri', 'chld_thm_cfg_locale_css' );
         
if ( !function_exists( 'child_theme_configurator_css' ) ):
    function child_theme_configurator_css() {
        wp_enqueue_style( 'chld_thm_cfg_child', trailingslashit( get_stylesheet_directory_uri() ) . 'style.css', array( 'neve-style','neve-style' ) );
    }
endif;
add_action( 'wp_enqueue_scripts', 'child_theme_configurator_css', 10 );

//* Google Analytics
function wpspecial_google_analytics() {
	?>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-108330865-5"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-108330865-5');
	</script>

	<?php
}
add_action('wp_head', 'wpspecial_google_analytics');

//Nascondo pulsante Aggiungi al carrello a utenti non loggati
/*add_action( 'init', 'seg_woo_mostra_pulsante_utenti_registrati' ); 
function seg_woo_mostra_pulsante_utenti_registrati() {
	if ( !is_user_logged_in() ) {
		remove_action( 'woocommerce_after_shop_loop_item', 'woocommerce_template_loop_add_to_cart', 10 );
		remove_action( 'woocommerce_single_product_summary', 'woocommerce_template_single_add_to_cart', 30 );
	}
}*/

/*
//	Escludere prodotti di particolari categorie dalla pagina shop

function nascondi_categorie_query( $q ) {
    $tax_query = (array) $q->get( 'tax_query' );
    $tax_query[] = array(
           'taxonomy' => 'product_cat',
           'field' => 'slug',
           'terms' => array( 'categoria-da-escludere' ), 
           'operator' => 'NOT IN'
    );
    $q->set( 'tax_query', $tax_query );
}
add_action( 'woocommerce_product_query', 'nascondi_categorie_query' ); 
*/

/*   Aggiungere Opzioni di ordinamento personalizzate

add_filter( 'woocommerce_get_catalog_ordering_args', 'custom_woocommerce_get_catalog_ordering_args' );

function custom_woocommerce_get_catalog_ordering_args( $args ) {
$orderby_value = isset( $_GET['orderby'] ) ? wc_clean( $_GET['orderby'] ) : apply_filters( 'woocommerce_default_catalog_orderby', get_option( 'woocommerce_default_catalog_orderby' ) );
if ( 'random_list' == $orderby_value ) {
$args['orderby'] = 'rand';
$args['order'] = '';
$args['meta_key'] = '';
}

return $args;
}

add_filter( 'woocommerce_default_catalog_orderby_options', 'custom_woocommerce_catalog_orderby' );
add_filter( 'woocommerce_catalog_orderby', 'custom_woocommerce_catalog_orderby' );

function custom_woocommerce_catalog_orderby( $sortby ) {
$sortby['random_list'] = 'Ordine casuale';
return $sortby;
}   */

//Nascondo pulsante Aggiungi al carrello per una o più Categorie prodotto
add_action('woocommerce_single_product_summary', 'remove_product_description_add_cart_button', 1 );
function remove_product_description_add_cart_button() { // function for deleting ...
    // Set HERE your category ID, slug or name (or an array)
    $categories = array('da-collezione');

    //Remove Add to Cart button from product description of product with specific Category
    if ( has_term( $categories, 'product_cat', get_the_id() ) ) {
        remove_action( 'woocommerce_single_product_summary', 'woocommerce_template_single_add_to_cart', 30 );
    }
}

//Cambio il titolo 'Dettagli Fatturazione' nella pagina checkout 
function wc_billing_field_strings( $translated_text, $text, $domain ) 
{ 
switch ( $translated_text ) 
{ 
case 'Dettagli di fatturazione' : 
$translated_text = __( 'Dettagli di contatto', 'woocommerce' ); 
break; 
} 
return $translated_text; 
} 
add_filter( 'gettext', 'wc_billing_field_strings', 20, 3 );

/*elimino campi non necessari al checkout*/
add_filter( 'woocommerce_billing_fields' , 'remove_billing_field' ); 
function remove_billing_field( $fields ) {
unset($fields['billing_company']);
unset($fields['billing_postcode']);
//unset($fields['billing_city']);
unset($fields['billing_address_1']);
unset($fields['billing_address_2']);
unset($fields['billing_state']);
//unset($fields['billing_country']);
return $fields;
}


// END ENQUEUE PARENT ACTION
