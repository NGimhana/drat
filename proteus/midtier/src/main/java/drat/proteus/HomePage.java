package drat.proteus;

import drat.proteus.method.DratMethod;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;


import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	final TextField<String> path = new TextField<String>("path",
			Model.of("")
	);
    final TextField<String> query = new TextField<String>("query",
            Model.of("")
    );

	public HomePage() {
		super();

		add(new FeedbackPanel("feedback"));

		path.setRequired(true);


		Form<?> form = new Form<Void>("form") {
			@Override
			protected void onSubmit() {
				PageParameters pageParameters = new PageParameters();
				pageParameters.add("path", path.getModelObject())
                        .add("query", query.getModelObject());
				//setResponsePage(DratMethod.class, pageParameters);
			}
		};
		form.setMultiPart(true);

		form.add(path).add(query);

		add(form);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
    }
}