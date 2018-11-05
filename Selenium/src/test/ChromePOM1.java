package test;


	import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class ChromePOM1 {
	    private Map<String, String> data;
	    
	    private int timeout = 15;

	    @FindBy(css = "#qqba_ div.flexslider ol.flex-control-nav.flex-control-paging li:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement _1;

	    @FindBy(css = "a.flex-active")
	    @CacheLookup
	    private WebElement _2;

	    @FindBy(css = "#qqba_ div.flexslider ol.flex-control-nav.flex-control-paging li:nth-of-type(4) a")
	    @CacheLookup
	    private WebElement _3;

	    @FindBy(css = "#qqba_ div.flexslider ol.flex-control-nav.flex-control-paging li:nth-of-type(5) a")
	    @CacheLookup
	    private WebElement _4;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/add-on-services']")
	    @CacheLookup
	    private WebElement addonServices;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/advanced-tracking']")
	    @CacheLookup
	    private WebElement advancedTracking;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/industrien-agrar-lebensmittel']")
	    @CacheLookup
	    private WebElement agrarLebensmittel;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-airmail']")
	    @CacheLookup
	    private WebElement airmailecommerce;

	    @FindBy(id = "_eportalroutingofferhomepage_WAR_eportalroutingofferportlet_INSTANCE_av33_airportCodeDestination")
	    @CacheLookup
	    private WebElement airportOfDestination;

	    @FindBy(id = "_eportalroutingofferhomepage_WAR_eportalroutingofferportlet_INSTANCE_av33_airportCodeOrigin")
	    @CacheLookup
	    private WebElement airportOfOrigin;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/industrien-automobil']")
	    @CacheLookup
	    private WebElement automobil;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/fleet/b777f']")
	    @CacheLookup
	    private WebElement b777f;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-tdbasic']")
	    @CacheLookup
	    private WebElement basic;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/fleet/belly-fleet']")
	    @CacheLookup
	    private WebElement bellyflotte;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/company/about-us']")
	    @CacheLookup
	    private WebElement berUns;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/booking']")
	    @CacheLookup
	    private WebElement booking;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-caretd']")
	    @CacheLookup
	    private WebElement care;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/cargo-diaries']")
	    @CacheLookup
	    private WebElement cargoDiaries;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/industrien-chemie']")
	    @CacheLookup
	    private WebElement chemie;

	    @FindBy(css = "a.closemenu")
	    @CacheLookup
	    private WebElement close;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/company/commitment']")
	    @CacheLookup
	    private WebElement commitment;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/commodity-needs']")
	    @CacheLookup
	    private WebElement commodityNeeds;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/company-facts']")
	    @CacheLookup
	    private WebElement companyFacts;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/ulds/containers']")
	    @CacheLookup
	    private WebElement container;

	    @FindBy(css = "#dropdown3 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li.row-fluid.cNavRow ul li:nth-of-type(2) ul.cNavItems li:nth-of-type(1) div.cNavItemSpacer a.cNavItemThree")
	    @CacheLookup
	    private WebElement cool;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/network/hubs-service-center/cool-center']")
	    @CacheLookup
	    private WebElement coolCenter;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/specials/corporate-app/app']")
	    @CacheLookup
	    private WebElement corporateApp;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-couriersolutions']")
	    @CacheLookup
	    private WebElement courierSolutions;

	    @FindBy(id = "trigger7")
	    @CacheLookup
	    private WebElement cps;

	    @FindBy(id = "_eportalroutingofferhomepage_WAR_eportalroutingofferportlet_INSTANCE_av33_routeDate")
	    @CacheLookup
	    private WebElement date;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/privacy-statement']")
	    @CacheLookup
	    private WebElement datenschutzerklrung;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/data-protection-notice-google-analytics']")
	    @CacheLookup
	    private WebElement datenschutzhinweisGoogleAnalytics;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/infothek/infothek-deutschland']")
	    @CacheLookup
	    private WebElement deutschland;

	    @FindBy(css = "a.headicon.booking")
	    @CacheLookup
	    private WebElement ebooking;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/efreight']")
	    @CacheLookup
	    private WebElement efreight;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-emergencysolutions']")
	    @CacheLookup
	    private WebElement emergencySolutions;

	    @FindBy(css = "a.taglib-language-list-text")
	    @CacheLookup
	    private WebElement english;

	    @FindBy(id = "_eportalcontactandstations_WAR_eportalmanagestationinformationportlet_INSTANCE_av331_airportCode")
	    @CacheLookup
	    private WebElement enterTheStationNameOrThe;

	    @FindBy(id = "trigger1")
	    @CacheLookup
	    private static WebElement eservices;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices-app']")
	    @CacheLookup
	    private WebElement eservicesApp;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/etracking']")
	    @CacheLookup
	    private WebElement etracking;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/feedback-support']")
	    @CacheLookup
	    private WebElement feedbackSupport;

	    @FindBy(css = "#dropdown3 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li.row-fluid.cNavRow ul li:nth-of-type(1) ul.cNavItems li:nth-of-type(3) div.cNavItemSpacer a.cNavItemThree")
	    @CacheLookup
	    private WebElement flash;

	    @FindBy(css = "#dropdown2 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li.row-fluid.cNavRow ul li:nth-of-type(1) ul.cNavItems li:nth-of-type(2) div.cNavItemSpacer a.cNavItemThree")
	    @CacheLookup
	    private WebElement flightradar;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/flight-data']")
	    @CacheLookup
	    private WebElement flugbersicht;

	    @FindBy(id = "trigger6")
	    @CacheLookup
	    private WebElement footer;

	    @FindBy(id = "_58_rjus__null__null")
	    @CacheLookup
	    private WebElement forgottenYourPassword;

	    @FindBy(id = "_58_ctvk__null__null")
	    @CacheLookup
	    private WebElement forgottenYourUserId;

	    @FindBy(id = "_eportalroutingofferhomepage_WAR_eportalroutingofferportlet_INSTANCE_av33_checkFreightTruckCheckbox")
	    @CacheLookup
	    private WebElement freighterAndTrucksOnly;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-freshtd']")
	    @CacheLookup
	    private WebElement fresh;

	    @FindBy(css = "a[href='/meta/meta/company/general-terms']")
	    @CacheLookup
	    private WebElement generalTerms;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/ulds/heat-and-cool-container']")
	    @CacheLookup
	    private WebElement heizUndKhlcontainer;

	    @FindBy(css = "#navigation div:nth-of-type(2) nav.top-nav ul.cf li:nth-of-type(1) a")
	    @CacheLookup
	    private WebElement home1;

	    @FindBy(id = "trigger0")
	    @CacheLookup
	    private WebElement home2;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/network/hubs-service-center']")
	    @CacheLookup
	    private WebElement hubsServiceCenter;

	    @FindBy(css = "a[href='/footer/bottomnav/imprint']")
	    @CacheLookup
	    private WebElement imprint;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/products-industries/industries-overview']")
	    @CacheLookup
	    private WebElement industrienImFokus;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/local-info/infothek-japan']")
	    @CacheLookup
	    private WebElement japan;

	    @FindBy(css = "a[href='http://www.be-lufthansa.com/en/companies/lufthansa-cargo/']")
	    @CacheLookup
	    private WebElement karriere;

	    @FindBy(id = "_58_login")
	    @CacheLookup
	    private WebElement keepMeLoggedIn1;

	    @FindBy(id = "_58_password")
	    @CacheLookup
	    private WebElement keepMeLoggedIn2;

	    @FindBy(id = "_58_rememberMeCheckbox")
	    @CacheLookup
	    private WebElement keepMeLoggedIn3;

	    @FindBy(id = "minisearchportlet_searchtext")
	    @CacheLookup
	    private WebElement keepMeLoggedIn4;

	    @FindBy(css = "input.suchen")
	    @CacheLookup
	    private WebElement keepMeLoggedIn5;

	    @FindBy(css = "#menu_1 a")
	    @CacheLookup
	    private WebElement kontakt;

	    @FindBy(css = "#subMenu_0 a.l2")
	    @CacheLookup
	    private WebElement kontaktDeutschland1;

	    @FindBy(css = "#dropdown5 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li:nth-of-type(1) ul li:nth-of-type(4) div:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement kontaktDeutschland2;

	    @FindBy(css = "#subMenu_1 a.l2")
	    @CacheLookup
	    private WebElement kontakteWeltweit1;

	    @FindBy(css = "#dropdown5 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li:nth-of-type(1) ul li:nth-of-type(5) div:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement kontakteWeltweit2;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/company/cooperations']")
	    @CacheLookup
	    private WebElement kooperationen;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/company/partner']")
	    @CacheLookup
	    private WebElement kunden;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/industrien-kunst-kultur']")
	    @CacheLookup
	    private WebElement kunstKultur;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/industrien-oel-gas']")
	    @CacheLookup
	    private WebElement lGas;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-livetd']")
	    @CacheLookup
	    private WebElement live;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/local-info']")
	    @CacheLookup
	    private WebElement localInfo;

	    @FindBy(css = "a.service-login")
	    @CacheLookup
	    private WebElement login1;

	    @FindBy(css = "button.btn.pull-left.marginT5.btn-primary")
	    @CacheLookup
	    private WebElement login2;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/company/lufthansa-cargo-group']")
	    @CacheLookup
	    private WebElement lufthansaCargoGroup;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/fleet/md-11f']")
	    @CacheLookup
	    private WebElement md11f;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/photo-video-gallery']")
	    @CacheLookup
	    private WebElement mediaGallery;

	    @FindBy(css = "#subMenu_2 a.l2")
	    @CacheLookup
	    private WebElement mediengalerie1;

	    @FindBy(css = "#dropdown5 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li:nth-of-type(1) ul li:nth-of-type(3) div:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement mediengalerie2;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/industrien-medizintechnik-pharma']")
	    @CacheLookup
	    private WebElement medizintechnikPharma;

	    @FindBy(css = "#qqba_ div.flexslider div.flex-viewport ul.slides li:nth-of-type(1) div.eportalHomeSliderOverlay.normal div.eportalHomeSliderOverlayText p:nth-of-type(3) a.more.")
	    @CacheLookup
	    private WebElement mehr1;

	    @FindBy(css = "#qqba_ div.flexslider div.flex-viewport ul.slides li:nth-of-type(2) div.eportalHomeSliderOverlay.indented div.eportalHomeSliderOverlayText p:nth-of-type(3) a.more.")
	    @CacheLookup
	    private WebElement mehr2;

	    @FindBy(css = "#qqba_ div.flexslider div.flex-viewport ul.slides li:nth-of-type(3) div.eportalHomeSliderOverlay.indented div.eportalHomeSliderOverlayText p:nth-of-type(3) a.more.")
	    @CacheLookup
	    private WebElement mehr3;

	    @FindBy(css = "a[href='https://www.myaircargo.com']")
	    @CacheLookup
	    private WebElement mehr4;

	    @FindBy(css = "#qqba_ div.flexslider div.flex-viewport ul.slides li:nth-of-type(5) div.eportalHomeSliderOverlay.normal div.eportalHomeSliderOverlayText p:nth-of-type(3) a.more.")
	    @CacheLookup
	    private WebElement mehr5;

	    @FindBy(css = "#qqba_ div.flexslider div.flex-viewport ul.slides li:nth-of-type(6) div.eportalHomeSliderOverlay.indented div.eportalHomeSliderOverlayText p:nth-of-type(3) a.more.")
	    @CacheLookup
	    private WebElement mehr6;

	    @FindBy(css = "a[href='/ebooking']")
	    @CacheLookup
	    private WebElement mehr7;

	    @FindBy(css = "#p_p_id_56_INSTANCE_C5m1IH5tbfwn_ div.portlet-borderless-container div.portlet-body div.journal-content-article div.row-fluid.moresection.marginB20.clearfix div.span4 a.more")
	    @CacheLookup
	    private WebElement mehr8;

	    @FindBy(css = "#p_p_id_56_INSTANCE_TY7be3aLQtjm_ div.portlet-borderless-container div.portlet-body div.journal-content-article div.row-fluid.moresection.marginB20.clearfix div.span4 a.more")
	    @CacheLookup
	    private WebElement mehr9;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/-/lufthansa-cargo-presents-award-to-panalpina']")
	    @CacheLookup
	    private WebElement mehrErfahren;

	    @FindBy(id = "trigger5")
	    @CacheLookup
	    private WebElement meta;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/more-services']")
	    @CacheLookup
	    private WebElement moreServices;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/network-on-demand-request']")
	    @CacheLookup
	    private WebElement networkondemand1;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/network-on-demand1']")
	    @CacheLookup
	    private WebElement networkondemand2;

	    @FindBy(id = "trigger2")
	    @CacheLookup
	    private WebElement netzwerk;

	    @FindBy(css = "a.flex-next")
	    @CacheLookup
	    private WebElement next;

	    @FindBy(id = "cookiePolicyOkButton")
	    @CacheLookup
	    private WebElement ok;

	    private final String pageLoadedText = "Verfolgen Sie die aktuellen Positionen unserer Frachter sowie die Positionen aller weiteren Flugzeuge der Lufthansa Flotte live im Flightradar";

	    private final String pageUrl = "web/guest/home";

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/ulds/pallets']")
	    @CacheLookup
	    private WebElement paletten;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/partnerships']")
	    @CacheLookup
	    private WebElement partnerschaften;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/press-media/planet-magazine/planet-overview']")
	    @CacheLookup
	    private WebElement planet;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/press-media']")
	    @CacheLookup
	    private WebElement pressPublications;

	    @FindBy(css = "#menu_0 a")
	    @CacheLookup
	    private WebElement presseMedien;

	    @FindBy(css = "#subMenu_1 a.l2")
	    @CacheLookup
	    private WebElement pressearchiv1;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/press-archive']")
	    @CacheLookup
	    private WebElement pressearchiv2;

	    @FindBy(css = "#dropdown5 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li:nth-of-type(1) ul li:nth-of-type(2) div:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement pressearchiv3;

	    @FindBy(css = "#subMenu_0 a.l2")
	    @CacheLookup
	    private WebElement pressemitteilungen1;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/press-media/press-releases']")
	    @CacheLookup
	    private WebElement pressemitteilungen2;

	    @FindBy(css = "#dropdown5 ul.dropdown-menu.mega-dropdown-menu.row-fluid.row5 li:nth-of-type(1) ul li:nth-of-type(1) div:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement pressemitteilungen3;

	    @FindBy(css = "a.flex-prev")
	    @CacheLookup
	    private WebElement previous;

	    @FindBy(css = "a[href='/footer/bottomnav/privacy']")
	    @CacheLookup
	    private WebElement privacy;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-tdpro']")
	    @CacheLookup
	    private WebElement pro;

	    @FindBy(id = "trigger3")
	    @CacheLookup
	    private WebElement produkte;

	    @FindBy(css = "a.headicon.productsearch.directLink")
	    @CacheLookup
	    private WebElement produktsuche;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/promotionnav']")
	    @CacheLookup
	    private WebElement promotion;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/promotion/promotion-newsletter']")
	    @CacheLookup
	    private WebElement promotionAbonnieren;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/etracking/quick-drop-off']")
	    @CacheLookup
	    private WebElement quickDropoff;

	    @FindBy(id = "_58_suxb__null__null")
	    @CacheLookup
	    private WebElement registerHere;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/rfs-partner']")
	    @CacheLookup
	    private WebElement rfs;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-road-feeder-service']")
	    @CacheLookup
	    private WebElement roadFeederService;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-safetd1']")
	    @CacheLookup
	    private WebElement safe1;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-safetd2']")
	    @CacheLookup
	    private WebElement safe2;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/network/schedule-routings']")
	    @CacheLookup
	    private WebElement scheduleRoutings1;

	    @FindBy(css = "a.headicon.routing")
	    @CacheLookup
	    private WebElement scheduleRoutings2;

	    @FindBy(id = "etrk_awbsearch")
	    @CacheLookup
	    private WebElement search1;

	    @FindBy(id = "etrk_hawbsearch")
	    @CacheLookup
	    private WebElement search2;

	    @FindBy(id = "airportCodeSearch")
	    @CacheLookup
	    private WebElement search3;

	    @FindBy(name = "searchFilter")
	    @CacheLookup
	    private List<WebElement> searchPleaseEnterAValidAwb1;

	    @FindBy(name = "searchFilter")
	    @CacheLookup
	    private List<WebElement> searchPleaseEnterAValidAwb2;

	    @FindBy(id = "etrk_awbp")
	    @CacheLookup
	    private WebElement searchPleaseEnterAValidAwb3;

	    @FindBy(id = "etrk_awbs")
	    @CacheLookup
	    private WebElement searchPleaseEnterAValidAwb4;

	    @FindBy(id = "etrk_hawb")
	    @CacheLookup
	    private WebElement searchPleaseEnterAValidAwb5;

	   // private final String searchPleaseEnterAValidAwbValue = "hawb";

	    //private final String searchPleaseEnterAValidAwbValue = "awb";

	    @FindBy(id = "_eportalroutingofferhomepage_WAR_eportalroutingofferportlet_INSTANCE_av33_submitButton")
	    @CacheLookup
	    private WebElement searchRoutes;

	    @FindBy(id = "_eportalroutingofferhomepage_WAR_eportalroutingofferportlet_INSTANCE_av33_serviceName")
	    @CacheLookup
	    private WebElement services;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/company/security']")
	    @CacheLookup
	    private WebElement sicherheit;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/company/responsibility']")
	    @CacheLookup
	    private WebElement sozialeVerantwortung;

	    @FindBy(id = "_eportalroutingofferhomepage_WAR_eportalroutingofferportlet_INSTANCE_av33_specialName")
	    @CacheLookup
	    private WebElement specials;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/speed']")
	    @CacheLookup
	    private WebElement speedNeeds;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/netzwerk/ubersichtskarten/stationen']")
	    @CacheLookup
	    private WebElement stationen;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/stations-hubs-more']")
	    @CacheLookup
	    private WebElement stationenHubsMehr;

	    @FindBy(css = "a.headicon.contact")
	    @CacheLookup
	    private WebElement stations;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/technical-support']")
	    @CacheLookup
	    private WebElement technicalSupport;

	    @FindBy(css = "a[href='/footer/bottomnav/terms-of-use']")
	    @CacheLookup
	    private WebElement termsOfUse;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-todoor']")
	    @CacheLookup
	    private WebElement todoor;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/eservices/tracking']")
	    @CacheLookup
	    private WebElement tracking1;

	    @FindBy(css = "a.headicon.tracking")
	    @CacheLookup
	    private WebElement tracking2;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/ulds']")
	    @CacheLookup
	    private WebElement ulds;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/ulds/ulds-for-live-animal']")
	    @CacheLookup
	    private WebElement uldsFrTiere;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/company/environment']")
	    @CacheLookup
	    private WebElement umweltschutz;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/fleet-ulds/fleet']")
	    @CacheLookup
	    private WebElement unsereFlotte;

	    @FindBy(id = "trigger4")
	    @CacheLookup
	    private WebElement unternehmen;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/press-media/corporate-app']")
	    @CacheLookup
	    private WebElement unternehmensApp;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/directory-of-procedures']")
	    @CacheLookup
	    private WebElement verfahrensverzeichnis;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/produkte-versicherung']")
	    @CacheLookup
	    private WebElement versicherung;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/company/executive-board']")
	    @CacheLookup
	    private WebElement vorstand;

	    @FindBy(css = "a[href='https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/de/web/guest/meta/meta/infothek/wartezeiten-frachtannahme-fra']")
	    @CacheLookup
	    private WebElement wartezeitenAnnahmeFra;

	    @FindBy(css = "a[href='/privacy-statement']")
	    @CacheLookup
	    private WebElement weitereInformationen;

	    @FindBy(id = "skip-to-content")
	    @CacheLookup
	    private WebElement zumInhaltWechseln;

	    @FindBy(css = "a[href='product-search']")
	    @CacheLookup
	    private WebElement zurProduktsuche;

	    public static WebDriver driver;
	    public ChromePOM1(WebDriver driver) {
	    	this.driver=driver;
	    }

	    public void Start() {
	        driver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/web/guest/home");
	        driver.manage().window().maximize();
	        ChromePOM1.eservices.click();
	    }

	   /* public ChromePOM1(WebDriver driver, Map<String, String> data) {
	        this(driver);
	        this.data = data;
	    }*/

	    /*public ChromePOM1(WebDriver driver, Map<String, String> data, int timeout) {
	        this(driver, data);
	        this.timeout = timeout;
	    }*/

	    /**
	     * Click on Addon Services Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickAddonServicesLink() {
	        addonServices.click();
	        return this;
	    }

	    /**
	     * Click on Advanced Tracking Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickAdvancedTrackingLink() {
	        advancedTracking.click();
	        return this;
	    }

	    /**
	     * Click on Agrar Lebensmittel Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickAgrarLebensmittelLink() {
	        agrarLebensmittel.click();
	        return this;
	    }

	    /**
	     * Click on Airmailecommerce Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickAirmailecommerceLink() {
	        airmailecommerce.click();
	        return this;
	    }

	    /**
	     * Click on Automobil Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickAutomobilLink() {
	        automobil.click();
	        return this;
	    }

	    /**
	     * Click on B777f Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickB777fLink() {
	        b777f.click();
	        return this;
	    }

	    /**
	     * Click on Basic Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickBasicLink() {
	        basic.click();
	        return this;
	    }

	    /**
	     * Click on Bellyflotte Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickBellyflotteLink() {
	        bellyflotte.click();
	        return this;
	    }

	    /**
	     * Click on Ber Uns Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickBerUnsLink() {
	        berUns.click();
	        return this;
	    }

	    /**
	     * Click on Booking Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickBookingLink() {
	        booking.click();
	        return this;
	    }

	    /**
	     * Click on Care Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCareLink() {
	        care.click();
	        return this;
	    }

	    /**
	     * Click on Cargo Diaries Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCargoDiariesLink() {
	        cargoDiaries.click();
	        return this;
	    }

	    /**
	     * Click on Chemie Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickChemieLink() {
	        chemie.click();
	        return this;
	    }

	    /**
	     * Click on Close Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCloseLink() {
	        close.click();
	        return this;
	    }

	    /**
	     * Click on Commitment Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCommitmentLink() {
	        commitment.click();
	        return this;
	    }

	    /**
	     * Click on Commodity Needs Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCommodityNeedsLink() {
	        commodityNeeds.click();
	        return this;
	    }

	    /**
	     * Click on Company Facts Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCompanyFactsLink() {
	        companyFacts.click();
	        return this;
	    }

	    /**
	     * Click on Container Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickContainerLink() {
	        container.click();
	        return this;
	    }

	    /**
	     * Click on Cool Center Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCoolCenterLink() {
	        coolCenter.click();
	        return this;
	    }

	    /**
	     * Click on Cool Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCoolLink() {
	        cool.click();
	        return this;
	    }

	    /**
	     * Click on Corporate App Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCorporateAppLink() {
	        corporateApp.click();
	        return this;
	    }

	    /**
	     * Click on Courier.solutions Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCourierSolutionsLink() {
	        courierSolutions.click();
	        return this;
	    }

	    /**
	     * Click on Cps Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickCpsLink() {
	        cps.click();
	        return this;
	    }

	    /**
	     * Click on Datenschutzerklrung Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickDatenschutzerklrungLink() {
	        datenschutzerklrung.click();
	        return this;
	    }

	    /**
	     * Click on Datenschutzhinweis Google Analytics Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickDatenschutzhinweisGoogleAnalyticsLink() {
	        datenschutzhinweisGoogleAnalytics.click();
	        return this;
	    }

	    /**
	     * Click on Deutschland Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickDeutschlandLink() {
	        deutschland.click();
	        return this;
	    }

	    /**
	     * Click on Ebooking Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickEbookingLink() {
	        ebooking.click();
	        return this;
	    }

	    /**
	     * Click on Efreight Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickEfreightLink() {
	        efreight.click();
	        return this;
	    }

	    /**
	     * Click on Emergency.solutions Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickEmergencySolutionsLink() {
	        emergencySolutions.click();
	        return this;
	    }

	    /**
	     * Click on English Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickEnglishLink() {
	        english.click();
	        return this;
	    }

	    /**
	     * Click on Eservices App Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickEservicesAppLink() {
	        eservicesApp.click();
	        return this;
	    }

	    /**
	     * Click on Eservices Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickEservicesLink() {
	        eservices.click();
	        return this;
	    }

	    /**
	     * Click on Etracking Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickEtrackingLink() {
	        etracking.click();
	        return this;
	    }

	    /**
	     * Click on Feedback Support Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickFeedbackSupportLink() {
	        feedbackSupport.click();
	        return this;
	    }

	    /**
	     * Click on Flash Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickFlashLink() {
	        flash.click();
	        return this;
	    }

	    /**
	     * Click on Flightradar Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickFlightradarLink() {
	        flightradar.click();
	        return this;
	    }

	    /**
	     * Click on Flugbersicht Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickFlugbersichtLink() {
	        flugbersicht.click();
	        return this;
	    }

	    /**
	     * Click on Footer Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickFooterLink() {
	        footer.click();
	        return this;
	    }

	    /**
	     * Click on Forgotten Your Password Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickForgottenYourPasswordLink() {
	        forgottenYourPassword.click();
	        return this;
	    }

	    /**
	     * Click on Forgotten Your User Id Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickForgottenYourUserIdLink() {
	        forgottenYourUserId.click();
	        return this;
	    }

	    /**
	     * Click on Fresh Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickFreshLink() {
	        fresh.click();
	        return this;
	    }

	    /**
	     * Click on General Terms Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickGeneralTermsLink() {
	        generalTerms.click();
	        return this;
	    }

	    /**
	     * Click on Heiz Und Khlcontainer Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickHeizUndKhlcontainerLink() {
	        heizUndKhlcontainer.click();
	        return this;
	    }

	    /**
	     * Click on Home Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickHome1Link() {
	        home1.click();
	        return this;
	    }

	    /**
	     * Click on Home Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickHome2Link() {
	        home2.click();
	        return this;
	    }

	    /**
	     * Click on Hubs Service Center Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickHubsServiceCenterLink() {
	        hubsServiceCenter.click();
	        return this;
	    }

	    /**
	     * Click on Imprint Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickImprintLink() {
	        imprint.click();
	        return this;
	    }

	    /**
	     * Click on Industrien Im Fokus Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickIndustrienImFokusLink() {
	        industrienImFokus.click();
	        return this;
	    }

	    /**
	     * Click on Japan Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickJapanLink() {
	        japan.click();
	        return this;
	    }

	    /**
	     * Click on Karriere Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKarriereLink() {
	        karriere.click();
	        return this;
	    }

	    /**
	     * Click on Keep Me Logged In Button.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKeepMeLoggedIn5Button() {
	        keepMeLoggedIn5.click();
	        return this;
	    }

	    /**
	     * Click on Kontakt Deutschland Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKontaktDeutschland1Link() {
	        kontaktDeutschland1.click();
	        return this;
	    }

	    /**
	     * Click on Kontakt Deutschland Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKontaktDeutschland2Link() {
	        kontaktDeutschland2.click();
	        return this;
	    }

	    /**
	     * Click on Kontakt Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKontaktLink() {
	        kontakt.click();
	        return this;
	    }

	    /**
	     * Click on Kontakte Weltweit Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKontakteWeltweit1Link() {
	        kontakteWeltweit1.click();
	        return this;
	    }

	    /**
	     * Click on Kontakte Weltweit Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKontakteWeltweit2Link() {
	        kontakteWeltweit2.click();
	        return this;
	    }

	    /**
	     * Click on Kooperationen Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKooperationenLink() {
	        kooperationen.click();
	        return this;
	    }

	    /**
	     * Click on Kunden Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKundenLink() {
	        kunden.click();
	        return this;
	    }

	    /**
	     * Click on Kunst Kultur Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickKunstKulturLink() {
	        kunstKultur.click();
	        return this;
	    }

	    /**
	     * Click on L Gas Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLGasLink() {
	        lGas.click();
	        return this;
	    }

	    /**
	     * Click on 1 Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLink1() {
	        _1.click();
	        return this;
	    }

	    /**
	     * Click on 2 Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLink2() {
	        _2.click();
	        return this;
	    }

	    /**
	     * Click on 3 Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLink3() {
	        _3.click();
	        return this;
	    }

	    /**
	     * Click on 4 Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLink4() {
	        _4.click();
	        return this;
	    }

	    /**
	     * Click on Live Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLiveLink() {
	        live.click();
	        return this;
	    }

	    /**
	     * Click on Local Info Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLocalInfoLink() {
	        localInfo.click();
	        return this;
	    }

	    /**
	     * Click on Login Button.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLogin1Button() {
	        login1.click();
	        return this;
	    }

	    /**
	     * Click on Login Button.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLogin2Button() {
	        login2.click();
	        return this;
	    }

	    /**
	     * Click on Lufthansa Cargo Group Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickLufthansaCargoGroupLink() {
	        lufthansaCargoGroup.click();
	        return this;
	    }

	    /**
	     * Click on Md11f Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMd11fLink() {
	        md11f.click();
	        return this;
	    }

	    /**
	     * Click on Media Gallery Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMediaGalleryLink() {
	        mediaGallery.click();
	        return this;
	    }

	    /**
	     * Click on Mediengalerie Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMediengalerie1Link() {
	        mediengalerie1.click();
	        return this;
	    }

	    /**
	     * Click on Mediengalerie Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMediengalerie2Link() {
	        mediengalerie2.click();
	        return this;
	    }

	    /**
	     * Click on Medizintechnik Pharma Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMedizintechnikPharmaLink() {
	        medizintechnikPharma.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr1Link() {
	        mehr1.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr2Link() {
	        mehr2.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr3Link() {
	        mehr3.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr4Link() {
	        mehr4.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr5Link() {
	        mehr5.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr6Link() {
	        mehr6.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr7Link() {
	        mehr7.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr8Link() {
	        mehr8.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehr9Link() {
	        mehr9.click();
	        return this;
	    }

	    /**
	     * Click on Mehr Erfahren Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMehrErfahrenLink() {
	        mehrErfahren.click();
	        return this;
	    }

	    /**
	     * Click on Meta Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMetaLink() {
	        meta.click();
	        return this;
	    }

	    /**
	     * Click on More Services Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickMoreServicesLink() {
	        moreServices.click();
	        return this;
	    }

	    /**
	     * Click on Networkondemand Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickNetworkondemand1Link() {
	        networkondemand1.click();
	        return this;
	    }

	    /**
	     * Click on Networkondemand Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickNetworkondemand2Link() {
	        networkondemand2.click();
	        return this;
	    }

	    /**
	     * Click on Netzwerk Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickNetzwerkLink() {
	        netzwerk.click();
	        return this;
	    }

	    /**
	     * Click on Next Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickNextLink() {
	        next.click();
	        return this;
	    }

	    /**
	     * Click on Ok Button.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickOkButton() {
	        ok.click();
	        return this;
	    }

	    /**
	     * Click on Paletten Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPalettenLink() {
	        paletten.click();
	        return this;
	    }

	    /**
	     * Click on Partnerschaften Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPartnerschaftenLink() {
	        partnerschaften.click();
	        return this;
	    }

	    /**
	     * Click on Planet Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPlanetLink() {
	        planet.click();
	        return this;
	    }

	    /**
	     * Click on Press Publications Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPressPublicationsLink() {
	        pressPublications.click();
	        return this;
	    }

	    /**
	     * Click on Presse Medien Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPresseMedienLink() {
	        presseMedien.click();
	        return this;
	    }

	    /**
	     * Click on Pressearchiv Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPressearchiv1Link() {
	        pressearchiv1.click();
	        return this;
	    }

	    /**
	     * Click on Pressearchiv Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPressearchiv2Link() {
	        pressearchiv2.click();
	        return this;
	    }

	    /**
	     * Click on Pressearchiv Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPressearchiv3Link() {
	        pressearchiv3.click();
	        return this;
	    }

	    /**
	     * Click on Pressemitteilungen Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPressemitteilungen1Link() {
	        pressemitteilungen1.click();
	        return this;
	    }

	    /**
	     * Click on Pressemitteilungen Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPressemitteilungen2Link() {
	        pressemitteilungen2.click();
	        return this;
	    }

	    /**
	     * Click on Pressemitteilungen Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPressemitteilungen3Link() {
	        pressemitteilungen3.click();
	        return this;
	    }

	    /**
	     * Click on Previous Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPreviousLink() {
	        previous.click();
	        return this;
	    }

	    /**
	     * Click on Privacy Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPrivacyLink() {
	        privacy.click();
	        return this;
	    }

	    /**
	     * Click on Pro Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickProLink() {
	        pro.click();
	        return this;
	    }

	    /**
	     * Click on Produkte Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickProdukteLink() {
	        produkte.click();
	        return this;
	    }

	    /**
	     * Click on Produktsuche Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickProduktsucheLink() {
	        produktsuche.click();
	        return this;
	    }

	    /**
	     * Click on Promotion Abonnieren Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPromotionAbonnierenLink() {
	        promotionAbonnieren.click();
	        return this;
	    }

	    /**
	     * Click on Promotion Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickPromotionLink() {
	        promotion.click();
	        return this;
	    }

	    /**
	     * Click on Quick Dropoff Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickQuickDropoffLink() {
	        quickDropoff.click();
	        return this;
	    }

	    /**
	     * Click on Register Here. Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickRegisterHereLink() {
	        registerHere.click();
	        return this;
	    }

	    /**
	     * Click on Rfs Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickRfsLink() {
	        rfs.click();
	        return this;
	    }

	    /**
	     * Click on Road Feeder Service Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickRoadFeederServiceLink() {
	        roadFeederService.click();
	        return this;
	    }

	    /**
	     * Click on Safe 1 Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSafe1Link() {
	        safe1.click();
	        return this;
	    }

	    /**
	     * Click on Safe 2 Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSafe2Link() {
	        safe2.click();
	        return this;
	    }

	    /**
	     * Click on Schedule Routings Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickScheduleRoutings1Link() {
	        scheduleRoutings1.click();
	        return this;
	    }

	    /**
	     * Click on Schedule Routings Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickScheduleRoutings2Link() {
	        scheduleRoutings2.click();
	        return this;
	    }

	    /**
	     * Click on Search Button.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSearch1Button() {
	        search1.click();
	        return this;
	    }

	    /**
	     * Click on Search Button.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSearch2Button() {
	        search2.click();
	        return this;
	    }

	    /**
	     * Click on Search Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSearch3Link() {
	        search3.click();
	        return this;
	    }

	    /**
	     * Click on Search Routes Button.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSearchRoutesButton() {
	        searchRoutes.click();
	        return this;
	    }

	    /**
	     * Click on Sicherheit Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSicherheitLink() {
	        sicherheit.click();
	        return this;
	    }

	    /**
	     * Click on Soziale Verantwortung Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSozialeVerantwortungLink() {
	        sozialeVerantwortung.click();
	        return this;
	    }

	    /**
	     * Click on Speed Needs Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickSpeedNeedsLink() {
	        speedNeeds.click();
	        return this;
	    }

	    /**
	     * Click on Stationen Hubs Mehr Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickStationenHubsMehrLink() {
	        stationenHubsMehr.click();
	        return this;
	    }

	    /**
	     * Click on Stationen Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickStationenLink() {
	        stationen.click();
	        return this;
	    }

	    /**
	     * Click on Stations Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickStationsLink() {
	        stations.click();
	        return this;
	    }

	    /**
	     * Click on Technical Support Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickTechnicalSupportLink() {
	        technicalSupport.click();
	        return this;
	    }

	    /**
	     * Click on Terms Of Use Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickTermsOfUseLink() {
	        termsOfUse.click();
	        return this;
	    }

	    /**
	     * Click on Todoor Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickTodoorLink() {
	        todoor.click();
	        return this;
	    }

	    /**
	     * Click on Tracking Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickTracking1Link() {
	        tracking1.click();
	        return this;
	    }

	    /**
	     * Click on Tracking Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickTracking2Link() {
	        tracking2.click();
	        return this;
	    }

	    /**
	     * Click on Ulds Fr Tiere Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickUldsFrTiereLink() {
	        uldsFrTiere.click();
	        return this;
	    }

	    /**
	     * Click on Ulds Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickUldsLink() {
	        ulds.click();
	        return this;
	    }

	    /**
	     * Click on Umweltschutz Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickUmweltschutzLink() {
	        umweltschutz.click();
	        return this;
	    }

	    /**
	     * Click on Unsere Flotte Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickUnsereFlotteLink() {
	        unsereFlotte.click();
	        return this;
	    }

	    /**
	     * Click on Unternehmen Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickUnternehmenLink() {
	        unternehmen.click();
	        return this;
	    }

	    /**
	     * Click on Unternehmens App Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickUnternehmensAppLink() {
	        unternehmensApp.click();
	        return this;
	    }

	    /**
	     * Click on Verfahrensverzeichnis Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickVerfahrensverzeichnisLink() {
	        verfahrensverzeichnis.click();
	        return this;
	    }

	    /**
	     * Click on Versicherung Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickVersicherungLink() {
	        versicherung.click();
	        return this;
	    }

	    /**
	     * Click on Vorstand Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickVorstandLink() {
	        vorstand.click();
	        return this;
	    }

	    /**
	     * Click on Wartezeiten Annahme Fra Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickWartezeitenAnnahmeFraLink() {
	        wartezeitenAnnahmeFra.click();
	        return this;
	    }

	    /**
	     * Click on Weitere Informationen Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickWeitereInformationenLink() {
	        weitereInformationen.click();
	        return this;
	    }

	    /**
	     * Click on Zum Inhalt Wechseln Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickZumInhaltWechselnLink() {
	        zumInhaltWechseln.click();
	        return this;
	    }

	    /**
	     * Click on Zur Produktsuche Link.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 clickZurProduktsucheLink() {
	        zurProduktsuche.click();
	        return this;
	    }

	    /**
	     * Fill every fields in the page.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 fill() {
	        setKeepMeLoggedIn1PasswordField();
	        setKeepMeLoggedIn2PasswordField();
	        setKeepMeLoggedIn3CheckboxField();
	        setKeepMeLoggedIn4TextField();
	        setAirportOfOriginTextField();
	        setAirportOfDestinationTextField();
	        setServicesDropDownListField();
	        setSpecialsDropDownListField();
	        setDateTextField();
	        setFreighterAndTrucksOnlyCheckboxField();
	        /*setSearchPleaseEnterAValidAwb1RadioButtonField();
	        setSearchPleaseEnterAValidAwb2RadioButtonField();*/
	        setSearchPleaseEnterAValidAwb3TextField();
	        setSearchPleaseEnterAValidAwb4TextField();
	        setSearchPleaseEnterAValidAwb5TextField();
	        setEnterTheStationNameOrTheTextField();
	        return this;
	    }

	    /**
	     * Fill every fields in the page and submit it to target page.
	     *
	     * @return the Eportal class instance.
	     */
	    /*public Eportal fillAndSubmit() {
	        fill();
	        return submit();
	    }*/

	    /**
	     * Set default value to Airport Of Destination Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setAirportOfDestinationTextField() {
	        return setAirportOfDestinationTextField(data.get("AIRPORT_OF_DESTINATION"));
	    }

	    /**
	     * Set value to Airport Of Destination Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setAirportOfDestinationTextField(String airportOfDestinationValue) {
	        airportOfDestination.sendKeys(airportOfDestinationValue);
	        return this;
	    }

	    /**
	     * Set default value to Airport Of Origin Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setAirportOfOriginTextField() {
	        return setAirportOfOriginTextField(data.get("AIRPORT_OF_ORIGIN"));
	    }

	    /**
	     * Set value to Airport Of Origin Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setAirportOfOriginTextField(String airportOfOriginValue) {
	        airportOfOrigin.sendKeys(airportOfOriginValue);
	        return this;
	    }

	    /**
	     * Set default value to Date Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setDateTextField() {
	        return setDateTextField(data.get("DATE"));
	    }

	    /**
	     * Set value to Date Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setDateTextField(String dateValue) {
	        date.sendKeys(dateValue);
	        return this;
	    }

	    /**
	     * Set default value to Enter The Station Name Or The Threeletter Code. Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setEnterTheStationNameOrTheTextField() {
	        return setEnterTheStationNameOrTheTextField(data.get("ENTER_THE_STATION_NAME_OR_THE"));
	    }

	    /**
	     * Set value to Enter The Station Name Or The Threeletter Code. Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setEnterTheStationNameOrTheTextField(String enterTheStationNameOrTheValue) {
	        enterTheStationNameOrThe.sendKeys(enterTheStationNameOrTheValue);
	        return this;
	    }

	    /**
	     * Set Freighter And Trucks Only Checkbox field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setFreighterAndTrucksOnlyCheckboxField() {
	        if (!freighterAndTrucksOnly.isSelected()) {
	            freighterAndTrucksOnly.click();
	        }
	        return this;
	    }

	    /**
	     * Set default value to Keep Me Logged In Password field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setKeepMeLoggedIn1PasswordField() {
	        return setKeepMeLoggedIn1PasswordField(data.get("KEEP_ME_LOGGED_IN_1"));
	    }

	    /**
	     * Set value to Keep Me Logged In Password field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setKeepMeLoggedIn1PasswordField(String keepMeLoggedIn1Value) {
	        keepMeLoggedIn1.sendKeys(keepMeLoggedIn1Value);
	        return this;
	    }

	    /**
	     * Set default value to Keep Me Logged In Password field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setKeepMeLoggedIn2PasswordField() {
	        return setKeepMeLoggedIn2PasswordField(data.get("KEEP_ME_LOGGED_IN_2"));
	    }

	    /**
	     * Set value to Keep Me Logged In Password field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setKeepMeLoggedIn2PasswordField(String keepMeLoggedIn2Value) {
	        keepMeLoggedIn2.sendKeys(keepMeLoggedIn2Value);
	        return this;
	    }

	    /**
	     * Set Keep Me Logged In Checkbox field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setKeepMeLoggedIn3CheckboxField() {
	        if (!keepMeLoggedIn3.isSelected()) {
	            keepMeLoggedIn3.click();
	        }
	        return this;
	    }

	    /**
	     * Set default value to Keep Me Logged In Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setKeepMeLoggedIn4TextField() {
	        return setKeepMeLoggedIn4TextField(data.get("KEEP_ME_LOGGED_IN_4"));
	    }

	    /**
	     * Set value to Keep Me Logged In Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setKeepMeLoggedIn4TextField(String keepMeLoggedIn4Value) {
	        keepMeLoggedIn4.sendKeys(keepMeLoggedIn4Value);
	        return this;
	    }

	    /**
	     * Set default value to Search Please Enter A Valid Awb Prefix Radio Button field.
	     *
	     * @return the Eportal class instance.
	     */
	   /* public Eportal setSearchPleaseEnterAValidAwb1RadioButtonField() {
	        for (WebElement el : searchPleaseEnterAValidAwb1) {
	            if (el.getAttribute("value").equals(searchPleaseEnterAValidAwb1Value)) {
	                if (!el.isSelected()) {
	                    el.click();
	                }
	                break;
	            }
	        }
	        return this;
	    }*/

	    /**
	     * Set default value to Search Please Enter A Valid Awb Prefix Radio Button field.
	     *
	     * @return the Eportal class instance.
	     */
	   /* public Eportal setSearchPleaseEnterAValidAwb2RadioButtonField() {
	        for (WebElement el : searchPleaseEnterAValidAwb2) {
	            if (el.getAttribute("value").equals(searchPleaseEnterAValidAwb2Value)) {
	                if (!el.isSelected()) {
	                    el.click();
	                }
	                break;
	            }
	        }
	        return this;
	    }*/

	    /**
	     * Set default value to Search Please Enter A Valid Awb Prefix Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSearchPleaseEnterAValidAwb3TextField() {
	        return setSearchPleaseEnterAValidAwb3TextField(data.get("SEARCH_PLEASE_ENTER_A_VALID_AWB_3"));
	    }

	    /**
	     * Set value to Search Please Enter A Valid Awb Prefix Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSearchPleaseEnterAValidAwb3TextField(String searchPleaseEnterAValidAwb3Value) {
	        searchPleaseEnterAValidAwb3.sendKeys(searchPleaseEnterAValidAwb3Value);
	        return this;
	    }

	    /**
	     * Set default value to Search Please Enter A Valid Awb Prefix Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSearchPleaseEnterAValidAwb4TextField() {
	        return setSearchPleaseEnterAValidAwb4TextField(data.get("SEARCH_PLEASE_ENTER_A_VALID_AWB_4"));
	    }

	    /**
	     * Set value to Search Please Enter A Valid Awb Prefix Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSearchPleaseEnterAValidAwb4TextField(String searchPleaseEnterAValidAwb4Value) {
	        searchPleaseEnterAValidAwb4.sendKeys(searchPleaseEnterAValidAwb4Value);
	        return this;
	    }

	    /**
	     * Set default value to Search Please Enter A Valid Awb Prefix Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSearchPleaseEnterAValidAwb5TextField() {
	        return setSearchPleaseEnterAValidAwb5TextField(data.get("SEARCH_PLEASE_ENTER_A_VALID_AWB_5"));
	    }

	    /**
	     * Set value to Search Please Enter A Valid Awb Prefix Text field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSearchPleaseEnterAValidAwb5TextField(String searchPleaseEnterAValidAwb5Value) {
	        searchPleaseEnterAValidAwb5.sendKeys(searchPleaseEnterAValidAwb5Value);
	        return this;
	    }

	    /**
	     * Set default value to Services Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setServicesDropDownListField() {
	        return setServicesDropDownListField(data.get("SERVICES"));
	    }

	    /**
	     * Set value to Services Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setServicesDropDownListField(String servicesValue) {
	        new Select(services).selectByVisibleText(servicesValue);
	        return this;
	    }

	    /**
	     * Set default value to Specials Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSpecialsDropDownListField() {
	        return setSpecialsDropDownListField(data.get("SPECIALS"));
	    }

	    /**
	     * Set value to Specials Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 setSpecialsDropDownListField(String specialsValue) {
	        new Select(specials).selectByVisibleText(specialsValue);
	        return this;
	    }

	    /**
	     * Submit the form to target page.
	     *
	     * @return the Eportal class instance.
	     */
	   /* public Eportal submit() {
	        clickKeepMeLoggedInButton();
	        return this;
	    }*/

	    /**
	     * Unset Freighter And Trucks Only Checkbox field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 unsetFreighterAndTrucksOnlyCheckboxField() {
	        if (freighterAndTrucksOnly.isSelected()) {
	            freighterAndTrucksOnly.click();
	        }
	        return this;
	    }

	    /**
	     * Unset Keep Me Logged In Checkbox field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 unsetKeepMeLoggedIn3CheckboxField() {
	        if (keepMeLoggedIn3.isSelected()) {
	            keepMeLoggedIn3.click();
	        }
	        return this;
	    }

	    /**
	     * Unset default value from Services Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 unsetServicesDropDownListField() {
	        return unsetServicesDropDownListField(data.get("SERVICES"));
	    }

	    /**
	     * Unset value from Services Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 unsetServicesDropDownListField(String servicesValue) {
	        new Select(services).deselectByVisibleText(servicesValue);
	        return this;
	    }

	    /**
	     * Unset default value from Specials Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 unsetSpecialsDropDownListField() {
	        return unsetSpecialsDropDownListField(data.get("SPECIALS"));
	    }

	    /**
	     * Unset value from Specials Drop Down List field.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 unsetSpecialsDropDownListField(String specialsValue) {
	        new Select(specials).deselectByVisibleText(specialsValue);
	        return this;
	    }

	    /**
	     * Verify that the page loaded completely.
	     *
	     * @return the Eportal class instance.
	     */
	    public ChromePOM1 verifyPageLoaded() {
	        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.getPageSource().contains(pageLoadedText);
	            }
	        });
	        return this;
	    }

	    /**
	     * Verify that current page URL matches the expected URL.
	     */
	    public void verifyPageUrl() {
	        
	                if (driver.getCurrentUrl().contains(pageUrl))
	                {
	                	System.out.println("correct url");
	                }
					
	            
	        }	        
	   }


