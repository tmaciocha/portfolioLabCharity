<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="fragments/header-form.jsp" %>
<!DOCTYPE html>
<%--import header--%>


<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="form-confirmation.html" method="post" modelAttribute="donation">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>


                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">

                        <label>
                            <input
                                    type="checkbox"
                                    name="categories"
                                    value="${category.id}"
                                    categoriesChecked="${category.name}"
                            />
                            <span class="checkbox"></span>
                            <span class="description">${category.name}</span>

                        </label>
                    </div>
                </c:forEach>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input type="number" min="0" path="quantity" name="bags" id="quantity" step="1"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <div class="form-group form-group--checkbox ">
                </div>

                <c:forEach items="${institutions}" var="institution">

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="institution"
                                   value="${institution.name} ${institution.description}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                      <div class="title">${institution.name}
                                      </div>
                              <div class="subtitle">
                                      ${institution.description}
                              </div>
                            </span>
                        </label>
                    </div>
                </c:forEach>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzeczy przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label for="street"> Ulica
                                <form:input id="street" path="street" name="address"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="city"> Miasto
                                <form:input id="city" path="city" name="city"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="zipCode">Kod pocztowy
                                <form:input id="zipCode" path="zipCode" name="postcode"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="phone">Numer telefonu
                                <form:input id="phone" path="phone" name="phone"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label for="pickUpDate"> Data
                                <form:input id="pickUpDate" path="pickUpDate" name="data" type="date"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="pickUpTime"> Godzina
                                <form:input path="pickUpTime" id="pickUpTime" name="time" type="time"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="pickUpComment"> Uwagi dla kuriera
                                <form:textarea id="pickUpComment" path="pickUpComment" rows="5" name="more_info"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span id="bagsSummary" class="summary--text"
                                ></span
                                >
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span id="institutionSummary" class="summary--text"
                                ></span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="streetSummary"></li>
                                <li id="citySummary"></li>
                                <li id="zipCodeSummary"></li>
                                <li id="phoneSummary"></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li></li>
                                <li id="pickUpDateSummary"></li>
                                <li id="pickUpTimeSummary"></li>
                                <li id="pickUpCommentSummary"></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<%@ include file="fragments/footer.jsp" %>