package tellh.com.recyclerstickyheaderview;

import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;

public class User extends DataBean {
    private String login;
    private int id;
    private String avatar_url;
    private boolean shouldSticky;

    public User() {
    }

    public User(String login, int id, String avatar_url) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.item_user;
    }

    public void setShouldSticky(boolean shouldSticky) {
        this.shouldSticky = shouldSticky;
    }

    @Override
    public boolean shouldSticky() {
        return shouldSticky;
    }

    public static String dataSource = "{\"items\": [\n" +
            "    {\n" +
            "      \"login\": \"JakeWharton\",\n" +
            "      \"id\": 66577,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/66577?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/JakeWharton\",\n" +
            "      \"html_url\": \"https://github.com/JakeWharton\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/JakeWharton/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/JakeWharton/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/JakeWharton/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/JakeWharton/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/JakeWharton/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/JakeWharton/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/JakeWharton/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/JakeWharton/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/JakeWharton/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"Trinea\",\n" +
            "      \"id\": 1169522,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/1169522?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/Trinea\",\n" +
            "      \"html_url\": \"https://github.com/Trinea\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/Trinea/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/Trinea/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/Trinea/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/Trinea/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/Trinea/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/Trinea/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/Trinea/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/Trinea/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/Trinea/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"chrisbanes\",\n" +
            "      \"id\": 227486,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/227486?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/chrisbanes\",\n" +
            "      \"html_url\": \"https://github.com/chrisbanes\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/chrisbanes/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/chrisbanes/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/chrisbanes/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/chrisbanes/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/chrisbanes/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/chrisbanes/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/chrisbanes/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/chrisbanes/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/chrisbanes/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"romannurik\",\n" +
            "      \"id\": 100155,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/100155?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/romannurik\",\n" +
            "      \"html_url\": \"https://github.com/romannurik\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/romannurik/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/romannurik/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/romannurik/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/romannurik/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/romannurik/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/romannurik/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/romannurik/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/romannurik/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/romannurik/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"koush\",\n" +
            "      \"id\": 73924,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/73924?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/koush\",\n" +
            "      \"html_url\": \"https://github.com/koush\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/koush/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/koush/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/koush/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/koush/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/koush/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/koush/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/koush/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/koush/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/koush/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"commonsguy\",\n" +
            "      \"id\": 103772,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/103772?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/commonsguy\",\n" +
            "      \"html_url\": \"https://github.com/commonsguy\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/commonsguy/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/commonsguy/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/commonsguy/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/commonsguy/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/commonsguy/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/commonsguy/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/commonsguy/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/commonsguy/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/commonsguy/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"hongyangAndroid\",\n" +
            "      \"id\": 10704521,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/10704521?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/hongyangAndroid\",\n" +
            "      \"html_url\": \"https://github.com/hongyangAndroid\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/hongyangAndroid/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/hongyangAndroid/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/hongyangAndroid/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/hongyangAndroid/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/hongyangAndroid/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/hongyangAndroid/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/hongyangAndroid/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/hongyangAndroid/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/hongyangAndroid/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"romainguy\",\n" +
            "      \"id\": 869684,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/869684?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/romainguy\",\n" +
            "      \"html_url\": \"https://github.com/romainguy\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/romainguy/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/romainguy/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/romainguy/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/romainguy/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/romainguy/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/romainguy/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/romainguy/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/romainguy/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/romainguy/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"singwhatiwanna\",\n" +
            "      \"id\": 3346272,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/3346272?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/singwhatiwanna\",\n" +
            "      \"html_url\": \"https://github.com/singwhatiwanna\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/singwhatiwanna/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/singwhatiwanna/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/singwhatiwanna/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/singwhatiwanna/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/singwhatiwanna/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/singwhatiwanna/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/singwhatiwanna/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/singwhatiwanna/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/singwhatiwanna/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"kevinsawicki\",\n" +
            "      \"id\": 671378,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/671378?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/kevinsawicki\",\n" +
            "      \"html_url\": \"https://github.com/kevinsawicki\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/kevinsawicki/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/kevinsawicki/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/kevinsawicki/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/kevinsawicki/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/kevinsawicki/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/kevinsawicki/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/kevinsawicki/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/kevinsawicki/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/kevinsawicki/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": true,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"cyrilmottier\",\n" +
            "      \"id\": 92794,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/92794?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/cyrilmottier\",\n" +
            "      \"html_url\": \"https://github.com/cyrilmottier\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/cyrilmottier/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/cyrilmottier/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/cyrilmottier/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/cyrilmottier/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/cyrilmottier/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/cyrilmottier/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/cyrilmottier/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/cyrilmottier/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/cyrilmottier/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"jgilfelt\",\n" +
            "      \"id\": 175697,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/175697?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/jgilfelt\",\n" +
            "      \"html_url\": \"https://github.com/jgilfelt\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/jgilfelt/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/jgilfelt/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/jgilfelt/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/jgilfelt/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/jgilfelt/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/jgilfelt/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/jgilfelt/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/jgilfelt/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/jgilfelt/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"greenrobot\",\n" +
            "      \"id\": 242242,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/242242?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/greenrobot\",\n" +
            "      \"html_url\": \"https://github.com/greenrobot\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/greenrobot/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/greenrobot/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/greenrobot/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/greenrobot/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/greenrobot/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/greenrobot/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/greenrobot/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/greenrobot/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/greenrobot/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"drakeet\",\n" +
            "      \"id\": 5214214,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/5214214?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/drakeet\",\n" +
            "      \"html_url\": \"https://github.com/drakeet\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/drakeet/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/drakeet/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/drakeet/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/drakeet/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/drakeet/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/drakeet/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/drakeet/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/drakeet/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/drakeet/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"unclebob\",\n" +
            "      \"id\": 36901,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/36901?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/unclebob\",\n" +
            "      \"html_url\": \"https://github.com/unclebob\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/unclebob/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/unclebob/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/unclebob/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/unclebob/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/unclebob/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/unclebob/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/unclebob/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/unclebob/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/unclebob/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"rengwuxian\",\n" +
            "      \"id\": 4454687,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/4454687?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/rengwuxian\",\n" +
            "      \"html_url\": \"https://github.com/rengwuxian\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/rengwuxian/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/rengwuxian/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/rengwuxian/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/rengwuxian/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/rengwuxian/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/rengwuxian/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/rengwuxian/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/rengwuxian/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/rengwuxian/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"rovo89\",\n" +
            "      \"id\": 1573299,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/1573299?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/rovo89\",\n" +
            "      \"html_url\": \"https://github.com/rovo89\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/rovo89/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/rovo89/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/rovo89/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/rovo89/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/rovo89/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/rovo89/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/rovo89/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/rovo89/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/rovo89/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"jfeinstein10\",\n" +
            "      \"id\": 1269143,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/1269143?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/jfeinstein10\",\n" +
            "      \"html_url\": \"https://github.com/jfeinstein10\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/jfeinstein10/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/jfeinstein10/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/jfeinstein10/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/jfeinstein10/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/jfeinstein10/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/jfeinstein10/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/jfeinstein10/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/jfeinstein10/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/jfeinstein10/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"SimonVT\",\n" +
            "      \"id\": 549365,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/549365?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/SimonVT\",\n" +
            "      \"html_url\": \"https://github.com/SimonVT\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/SimonVT/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/SimonVT/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/SimonVT/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/SimonVT/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/SimonVT/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/SimonVT/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/SimonVT/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/SimonVT/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/SimonVT/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"shiffman\",\n" +
            "      \"id\": 191758,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/191758?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/shiffman\",\n" +
            "      \"html_url\": \"https://github.com/shiffman\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/shiffman/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/shiffman/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/shiffman/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/shiffman/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/shiffman/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/shiffman/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/shiffman/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/shiffman/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/shiffman/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false,\n" +
            "      \"score\": 1.0\n" +
            "    }\n" +
            "  ]" +
            "}";


}